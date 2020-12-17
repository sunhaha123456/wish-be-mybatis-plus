package com.wish.controler;

import com.wish.common.data.response.StringResponse;
import com.wish.common.util.ValueHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@Slf4j
@RestController
@RequestMapping("/user/test")
public class TestControler {

    @Inject
    private ValueHolder valueHolder;

    @GetMapping(value = "/a1")
    public StringResponse a1() {
        return new StringResponse("success");
    }
}