package springboot.springbootapp.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {

        ModelAndView mav = new ModelAndView();

        mav.addObject("url", req.getRequestURI());
        mav.addObject("httpMethod", req.getMethod());
        mav.addObject("exception", e);

        mav.setViewName(ERROR_VIEW);

        return mav;
    }
}
