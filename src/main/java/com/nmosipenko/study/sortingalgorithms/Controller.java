package com.nmosipenko.study.sortingalgorithms;

import com.nmosipenko.study.sortingalgorithms.services.IntegerSortService;
import com.nmosipenko.study.sortingalgorithms.sorting.SelectionSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Osipenko-NM
 * mail NMOsipenko@mail.ru
 * @link https://github.com/NMOsipenko
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
    private final ApplicationContext applicationContext;
    private ResponseEntity<String> response;

    private String endpoint;

    @Autowired
    public Controller(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostMapping("api/sort")
    public ResponseEntity<String> sort(final HttpServletRequest request) {
        this.endpoint = request.getRequestURI();
        logStart();

        long timeStart = System.currentTimeMillis();

        List<Integer> sortList = new IntegerSortService(new SelectionSort()).sort();

        long timeStop = System.currentTimeMillis();

        this.response = new ResponseEntity<>("Time = [" + (timeStop - timeStart) + "] " + sortList,
                HttpStatus.OK);

        logOutResponse();
        logEnd();

        return response;

    }


        @GetMapping("api/HelloWorld")
    public ResponseEntity<String> helloWorld(final HttpServletRequest request) {
        this.endpoint = request.getRequestURI();
        logStart();

        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(System.currentTimeMillis());

        this.response = new ResponseEntity<>("Hello World. " +
                "Response from '" + this.endpoint + "'. Current server time : " + cal.getTime(),
                HttpStatus.OK);

        logOutResponse();
        logEnd();

        return response;

    }

    @PostMapping("api/GetEcho")
    public ResponseEntity<String> getEcho(final HttpServletRequest request,
                                          @RequestBody(required = false) final String data,
                                          @RequestHeader final HttpHeaders headers) {

        this.endpoint = request.getRequestURI();
        logStart();
        logInRequest(data, headers);

        this.response = new ResponseEntity<>(data, HttpStatus.OK);

        logOutResponse();
        logEnd();

        return this.response;
    }

    private void logStart() {
        LOGGER.info("Start endpoint '" + this.endpoint + "'");
    }

    private void logEnd() {
        LOGGER.info("Stop endpoint '" + this.endpoint + "'");
    }

    private void logInRequest(final String data,
                              final HttpHeaders headers) {
        LOGGER.debug("Endpoint '" + this.endpoint + "' REQUEST HttpHeaders : " + headers + " RequestBody : [" +
                (data == null ? "null" : data) + "]");
    }

    private void logOutResponse() {
        LOGGER.debug("Endpoint '" + this.endpoint + "' RESPONSE HttpHeader : " +
                (this.response != null ? this.response.getHeaders() : "[default headers]") +
                " ResponseBody : [" +
                (this.response != null && this.response.hasBody() ? this.response.getBody() : "null") +
                "]");
    }

}
