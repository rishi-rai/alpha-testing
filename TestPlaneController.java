package com.cognizant.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.controller.HangarController;
import com.cognizant.controller.PlaneController;
import com.cognizant.model.PlaneModel;
import com.cognizant.service.PlaneService;

public class TestPlaneController {
	
	private MockMvc mockMvc;
	
	@Spy
	@Autowired
	private PlaneService planeService;
	
	@Spy
	@Autowired
	@Qualifier("planeValidator")
	private Validator validator;
	
	 @InjectMocks
	 private PlaneController planeController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(planeController)
                .build();
	}

	

	@Test
	public void testPersistPlaneMethod_positive() {
		
		PlaneModel planeModel = new PlaneModel();
		planeModel.setOwnerContactNo(87878798);
		planeModel.setOwnerEmail("drrishiraj999@gmail.com");
		planeModel.setOwnerFirstName("Rishi");
		planeModel.setOwnerId(32423);
		planeModel.setOwnerLastName("Raj");
		planeModel.setPlaneCapacity(32);
		planeModel.setPlaneId(322);
		planeModel.setPlaneType("dsfa");
		
		Errors errors = new BeanPropertyBindingResult(planeModel, "planeId");
		
		ModelAndView mv = planeController.persistPlane(planeModel, errors);
		
		String actual = mv.getViewName();
		String expected ="planeForm";
		assertEquals(expected,actual);
		
	}
	
	@Test
public void testUpdatePlaneMethod_positive() {
		
		PlaneModel planeModel = new PlaneModel();
		planeModel.setOwnerContactNo(87878798);
		planeModel.setOwnerEmail("drrishiraj999@gmail.com");
		planeModel.setOwnerFirstName("Rishi");
		planeModel.setOwnerId(32423);
		planeModel.setOwnerLastName("Raj");
		planeModel.setPlaneCapacity(32);
		planeModel.setPlaneId(322);
		planeModel.setPlaneType("dsfa");
		
		Errors errors = new BeanPropertyBindingResult(planeModel, "planeId");
		
		ModelAndView mv = planeController.updatePlane(planeModel, errors);
		
		String actual = mv.getViewName();
		String expected ="viewOnePlane";
		assertEquals(expected,actual);
		
	}
	
	@Test
	public void testViewPlaneMethod_positive() {
			ModelMap map = new ModelMap();
			PlaneModel planeModel = new PlaneModel();
			planeModel.setOwnerContactNo(87878798);
			planeModel.setOwnerEmail("drrishiraj999@gmail.com");
			planeModel.setOwnerFirstName("Rishi");
			planeModel.setOwnerId(32423);
			planeModel.setOwnerLastName("Raj");
			planeModel.setPlaneCapacity(32);
			planeModel.setPlaneId(322);
			planeModel.setPlaneType("dsfa");
			
			Errors errors = new BeanPropertyBindingResult(planeModel, "planeId");
			
			ModelAndView mv = planeController.viewPlane(map, planeModel, 55);
			String actual = mv.getViewName();
			String expected ="planeForm";
			assertEquals(expected,actual);
			
		}
}
