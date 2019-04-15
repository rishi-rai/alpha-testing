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

import com.cognizant.controller.AdminController;
import com.cognizant.controller.HangarController;
import com.cognizant.model.HangarModel;
import com.cognizant.model.HangarStatusModel;
import com.cognizant.service.HangarService;
import com.cognizant.service.HangarServiceImpl;
import com.cognizant.service.PlaneService;
import com.cognizant.service.PlaneServiceImpl;
import com.cognizant.validation.HangarValidator;

public class TestHangarController {
	
	private MockMvc mockMvc;
	@Autowired
	@Spy
	HangarServiceImpl hangarService;
	
	@Autowired
	@Qualifier("hangarValidator")
	@Spy
	private HangarValidator validator;
	
	@Autowired
	@Spy
	private PlaneServiceImpl planeService;
	
	 @InjectMocks
	 private HangarController hangarController;
	 


	@Before
	public void init() {
		
		 MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders
	                .standaloneSetup(hangarController)
	                .build();
	}

	

	@Test
	public void testAllocatePlaneMethod_Positive() {
		
	try{
			HangarStatusModel hangarStatusModel = new HangarStatusModel();
			
			hangarStatusModel.setAvailableFromDate("uisgacf");
			hangarStatusModel.setAvailableTillDate("ugkdab");
			hangarStatusModel.setHangarId(67);
			hangarStatusModel.setManagerId("sakgd");
			hangarStatusModel.setOccupancyFromDate("slgahd");
			hangarStatusModel.setOccupancyTillDate("sagd");
			hangarStatusModel.setPlaneId(67);
			hangarStatusModel.setStatus("O");
			
			ModelAndView mv = hangarController.allocatePlaneMethod(hangarStatusModel);
			
			String actual = mv.getViewName();
			String expected ="hangarAllocationForm";
			assertEquals(expected, actual);
		
	}catch(Exception e){
		System.out.println("#################%%%%%%%%%%$$$$$$$$$");
		e.printStackTrace();
	}
	}

	
	@Test
	public void testPersistHangarMethod_Positive(){
		
		HangarModel hangarModel = new HangarModel();
		
		hangarModel.setHangarCity("gsddg");
		hangarModel.setHangarId(5445);
		hangarModel.setHangarState("ufgsd");
		hangarModel.setHangarZipCode(34321);
		hangarModel.setManagerAddressLine1("sdkfjagkjsab");
		hangarModel.setManagerAddressLine2("dffuh");
		hangarModel.setManagerId("slfihd");
		
		try{
		Errors errors = new BeanPropertyBindingResult(hangarModel,"HangarId");
		
		ModelAndView mv = hangarController.persistHangar(hangarModel,errors);	
		String actual = mv.getViewName();
		String expected ="hangarForm";
		assertEquals(expected, actual);
		}catch(Exception e){}
	}
	
	@Test
	public void testSetAllocationViewMethiod_Positive(){
		try{
		ModelAndView mv = hangarController.setAllocationView();
		String actual = mv.getViewName();
		String expected ="viewHangerAllocation";
		assertEquals(expected,actual);
	}catch(Exception e){}
		
	}
	
	@Test
	public void testUpadateHanagarMethod_postive(){
	HangarModel hangarModel = new HangarModel();
		
		hangarModel.setHangarCity("gsddg");
		hangarModel.setHangarId(5445);
		hangarModel.setHangarState("ufgsd");
		hangarModel.setHangarZipCode(34321);
		hangarModel.setManagerAddressLine1("sdkfjagkjsab");
		hangarModel.setManagerAddressLine2("dffuh");
		hangarModel.setManagerId("slfihd");
		try{
			Errors errors = new BeanPropertyBindingResult(hangarModel,"HangarId");
			ModelAndView mv = hangarController.updateHangar(hangarModel,errors);
		String actual =	mv.getViewName();
		String expected = "viewOneHangar";
			assertEquals(expected, actual);
		}catch(Exception e ){}
		
	}
	
	@Test
	public void testViewAllocationFormMethod_Positive(){
		ModelMap map = new ModelMap();
		try{
		ModelAndView mv = hangarController.viewAllocationForm(map,87,"dsg");
		String actual = mv.getViewName();
		String expected ="hangarAllocationForm";
		assertEquals(expected,actual);
		}catch(Exception e ){}
		
	}
	
	@Test
	public void testViewHangarMethod_Positive(){
		
		ModelMap map = new ModelMap();
		HangarModel hangarModel = new HangarModel();
		hangarModel.setHangarCity("gsddg");
		hangarModel.setHangarId(5445);
		hangarModel.setHangarState("ufgsd");
		hangarModel.setHangarZipCode(34321);
		hangarModel.setManagerAddressLine1("sdkfjagkjsab");
		hangarModel.setManagerAddressLine2("dffuh");
		hangarModel.setManagerId("slfihd");
		try{
			
			ModelAndView mv = hangarController.viewHangar(map, hangarModel, 34);
			
			String actual = mv.getViewName();
			String expected ="viewOneHangar";
			assertEquals(expected, actual);
		}catch(Exception e){}
		
	}
}
