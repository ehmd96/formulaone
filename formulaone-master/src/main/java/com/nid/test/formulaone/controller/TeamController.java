package com.nid.test.formulaone.controller;

import com.nid.test.formulaone.domain.Team;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController extends BaseController<Team> {
}
