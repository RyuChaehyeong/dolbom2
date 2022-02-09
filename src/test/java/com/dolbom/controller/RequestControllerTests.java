package com.dolbom.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class RequestControllerTests {

    @Setter(onMethod_ = {@Autowired})
    private WebApplicationContext cxt;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(cxt).build();
    }

    @Test
    public void testRegister() throws Exception {

        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/request/registerRequest")
                .param("srvcId", "77")
                .param("custId", "cust9")
                .param("reqTitle", "testest")
                .param("postcode", "1234")
                .param("custLoc", "testadd")
                .param("detailAddress", "asdfgh")
                .param("startDt", "2021-06-01")
                .param("endDt", "2021-06-20")
                .param("reqDtl", "aaaaa")
                .param("createdBy", "cust9")
                .param("lastModifiedBy", "cust9")

        ).andReturn().getModelAndView().getViewName();
        log.info(resultPage);
    }


    @Test
    public void testGet() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders
                        .get("/request/retrieveRequest")
                        .param("reqId", "7"))
                .andReturn()
                .getModelAndView().getModelMap()
        );
    }
}
