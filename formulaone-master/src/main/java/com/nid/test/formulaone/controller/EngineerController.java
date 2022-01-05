package com.nid.test.formulaone.controller;

import com.nid.test.formulaone.domain.Engineer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/engineer")
public class EngineerController extends BaseController<Engineer> {}
