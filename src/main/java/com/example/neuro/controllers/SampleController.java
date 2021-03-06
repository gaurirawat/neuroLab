package com.example.neuro.controllers;

import com.example.neuro.beans.Sample;
import com.example.neuro.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("sample/")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/getAll")
    public List<Sample> getSamples() {
        return sampleService.getSamplesRest();
    }

    @GetMapping("/getOne")
    public Sample getSample(@RequestParam Integer id) {
        return sampleService.getSampleRest(id);
    }

    @PostMapping("/insert")
    public Sample addSample(@Valid @RequestBody Sample sample) {
        return sampleService.addSampleRest(sample);
    }

//    @PostMapping("/insert")
//    public Sample addSample(@Valid @RequestBody Sample sample, @RequestParam Integer mId) {
//        return sampleService.addSampleRest(sample, mId);
//    }
}
