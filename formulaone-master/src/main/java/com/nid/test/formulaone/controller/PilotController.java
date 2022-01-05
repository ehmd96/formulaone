package com.nid.test.formulaone.controller;

import com.nid.test.formulaone.domain.Pilot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pilot")
public class PilotController extends BaseController<Pilot> {
}
