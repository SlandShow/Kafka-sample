package com.slandshow.kafkaconsumer.controller;

import com.slandshow.kafkaconsumer.Message;
import com.slandshow.kafkaconsumer.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/message")
@AllArgsConstructor
@Api(value = "/message", produces = "application/json")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @ApiOperation(value = "Receive all messages from Casandra")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message received"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Entry not found")
    })
    @GetMapping(value = "/getAll")
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @ApiOperation(value = "Receive message from Casandra")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message received"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Entry not found")
    })
    @GetMapping(value = "/getById")
    public Message getById(@RequestParam UUID id) {
        return messageService.getById(id);
    }

}
