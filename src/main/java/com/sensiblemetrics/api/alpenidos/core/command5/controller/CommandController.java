package com.sensiblemetrics.api.alpenidos.core.command5.controller;

import com.sensiblemetrics.api.alpenidos.core.command5.service.CalculationInvoker;
import com.sensiblemetrics.api.alpenidos.core.command5.service.ElementaryArithCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@Scope("session")
public class CommandController {

	@RequestMapping(value = "/cmd", method = RequestMethod.GET)
	public String index() {
		return "cmdindex";
	}
	
	@Autowired
    private CalculationInvoker invoker;
	
	@RequestMapping(value = "/cmd/cmpt", method = RequestMethod.GET)
	public @ResponseBody Integer compute(final HttpSession session, @RequestParam(value="operand") final int operand, @RequestParam(value="operator") final String operator) {
		ElementaryArithCalculator receiver;
		if (session.getAttribute("calculator") == null) {
            session.setAttribute("calculator", new ElementaryArithCalculator());
        }
		receiver = (ElementaryArithCalculator)session.getAttribute("calculator");
        this.invoker.compute(receiver, operator, operand);
		return receiver.getResult();
	}
	
	@RequestMapping(value = "/cmd/undo", method = RequestMethod.GET)
	public @ResponseBody Integer undo(HttpSession session) {
		ElementaryArithCalculator receiver;
		if (session.getAttribute("calculator") == null) {
            session.setAttribute("calculator", new ElementaryArithCalculator());
        }
		receiver = (ElementaryArithCalculator)session.getAttribute("calculator");
		this.invoker.undo();
		return receiver.getResult();
	}
	
	@RequestMapping(value = "/cmd/clr", method = RequestMethod.GET)
	public @ResponseBody Integer clear(HttpSession session) {
		final ElementaryArithCalculator receiver = new ElementaryArithCalculator();
		session.setAttribute("calculator", receiver);
		return receiver.getResult();
	}
}
