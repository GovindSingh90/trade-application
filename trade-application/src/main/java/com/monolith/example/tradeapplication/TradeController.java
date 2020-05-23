package com.monolith.example.tradeapplication;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TradeController {
	
	User tradeUser = new User();
	Map<String, Trade> tradeObj = new HashMap<>();
	Map<String, Double> tradeValue = new HashMap<>();
	public TradeController(){
		tradeValue.put("WIPRO", 298.45);
		tradeValue.put("INFY", 949.95);
		tradeValue.put("TCS", 2713.70);
		tradeValue.put("TECHM", 485.85);
	}
	@RequestMapping(value = "/trade/do", method = RequestMethod.POST)
	@ResponseBody
	public String tradeDo(@ModelAttribute("ticker")String ticker,@ModelAttribute("qty")int quantity,HttpServletRequest request){
		double tradeamount = tradeValue.get(ticker);
		Trade t = new Trade(ticker,tradeamount, quantity);
		double totalCost = tradeamount*quantity;
		
		t.setTotalCost(totalCost);
		tradeObj.put(ticker, t);
		tradeUser = (User)request.getSession().getAttribute("user");
		double ramaingAmount = tradeUser.getBalance()-totalCost;
		tradeUser.setBalance(ramaingAmount);
		
		return "<html><body bgcolor='coral'>Trade SuccesFully"+ tradeUser.getUserId()+"your balance is now::"
				+ "<br><a href='http://localhost:8080/trade.html'> Trade Again</a>"+"<br> <a href='http://localhost:8080/index.html'>Exit</a>";
	}
	
	
	

}
