package com.logistics.logisticssystem.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.logistics.logisticssystem.LogisticsSystemApplication;
import com.logistics.logisticssystem.common.enums.ResponseCode;
import com.logistics.logisticssystem.common.model.ResponseDTO;
import com.logistics.logisticssystem.common.util.JsonUtil;
import com.logistics.logisticssystem.dto.cainiao.*;
import com.logistics.logisticssystem.dto.cainiao.req.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@Slf4j
@DisplayName("对接菜鸟接口测试")
@SpringBootTest(classes = LogisticsSystemApplication.class)
public class CaiNiaoControllerTest {

    private static final String ROOT_PATH = "/logistics/cai-niao";

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    protected ObjectMapper objectMapper;

    protected MockMvc mockMvc;

    protected MockMvc mockMvcException;

    @Test
    @DisplayName("物流详情查询接口测试")
    public void queryLogisticsDetailsTest() throws Exception {
        ReqLogisticsInterfaceEntityDTO req = new ReqLogisticsInterfaceEntityDTO();
        req.setCpCode("SF").setMailNo("运单号");
        ResponseBaseDTO.LogisticsInterfaceResponseEntityDTO detailsDTO = this.normalTest(this.doPostJson(ROOT_PATH, "/getLogisticsDetails", req),
                ResponseBaseDTO.LogisticsInterfaceResponseEntityDTO.class);
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.print("物流详情查询接口测试结果：");
        System.out.println(detailsDTO);
    }

    @Test
    @DisplayName("获取发货地，CP开通状态，账户的使用情况")
    public void getLogisticsChannelTest() throws Exception {
        ReqWaybillSubscriptionEntityDTO subscriptionDTO = new ReqWaybillSubscriptionEntityDTO();
        ResponseBaseDTO.WaybillSubscriptionResponseEntityDTO result = this.normalTest(this.doPostJson(ROOT_PATH, "/getWaybillAccount", subscriptionDTO), ResponseBaseDTO.WaybillSubscriptionResponseEntityDTO.class);
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.print("获取发货地，CP开通状态，账户的使用情况接口测试结果：");
        System.out.println(result);
    }

    @Test
    @DisplayName("获取标准电子面单模板")
    public void getStandardTemplateTest() throws Exception {
        ReqGetStandardTemplateEntityDTO standardTemplateDTO = new ReqGetStandardTemplateEntityDTO();
        standardTemplateDTO.setCpCode("SF");
        ResponseBaseDTO.WayBillTemplateResponseEntityDTO result = this.normalTest(this.doPostJson(ROOT_PATH, "/getStandardTemplate", standardTemplateDTO), ResponseBaseDTO.WayBillTemplateResponseEntityDTO.class);
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.print("获取标准电子面单模板接口测试结果：");
        System.out.println(result);
    }

    @Test
    @DisplayName("获取电子面单号")
    public void getWaybillTest() throws Exception {
        ReqWebBillGetEntityDTO reqWebBillGetDTO = new ReqWebBillGetEntityDTO();

        //快递公司编码
        reqWebBillGetDTO.setCpCode("SF");

        //发件人信息
        UserInfoEntityDTO userInfoDTO = new UserInfoEntityDTO();
        userInfoDTO.setPhone("手机号").setName("名字");
        userInfoDTO.setAddress(new AddressEntityDTO().setProvince("省").setCity("市").setDistrict("区").setTown("镇").setDetail("街道门牌号"));
        reqWebBillGetDTO.setSender(userInfoDTO);

        TradeOrderInfoEntityDTO tradeOrderInfoDTO = new TradeOrderInfoEntityDTO();
        tradeOrderInfoDTO.setObjectId("1");
        Map<String, Object> hashMap = new HashMap<>();
//		hashMap.put("COD", new ValueEntityDTO<Double>().setValue(100.5));
        tradeOrderInfoDTO.setLogisticsServices(JsonUtil.toJSONString(hashMap));
        tradeOrderInfoDTO.setOrderInfo(new OrderInfoEntityDTO().setOrderChannelsType("OTHERS").setTradeOrderList(List.of("订单号")));
        //商品名称和商品描述不能相同 订单号和包裹号不能相同
        tradeOrderInfoDTO.setPackageInfo(new PackageInfoEntityDTO().setId("自己定义的包裹号").setItems(List.of(new PackageItemEntityDTO().setName("商品").setCount(1))).setGoodsDescription("商品详情"));
        tradeOrderInfoDTO.setRecipient(new UserInfoEntityDTO().setName("名字").setPhone("手机号").setAddress(new AddressEntityDTO().setCity("市").setDetail("街道门牌号").setProvince("省").setDistrict("区").setTown("镇")));
        tradeOrderInfoDTO.setTemplateUrl("菜鸟物流平台获取到的电子面单模板链接");
        //userId无用随便传的
        tradeOrderInfoDTO.setUserId(1L);
        reqWebBillGetDTO.setTradeOrderInfoDtos(List.of(tradeOrderInfoDTO));

        //特殊业务使用，如需使用请联系对接人员。
        reqWebBillGetDTO.setStoreCode("无");
        reqWebBillGetDTO.setResourceCode("无");
        reqWebBillGetDTO.setDmsSorting(false);

        //云打印数据是否加密 必须传true https://support-cnkuaidi.taobao.com/doc.htm?spm=0.0.0.0.MklOkH#?docType=1&docId=109433
        reqWebBillGetDTO.setNeedEncrypt(true);

        //扩展信息 （付费类型） 月结卡号
        Map<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("payMethod", 1);
        reqWebBillGetDTO.setExtraInfo(JsonUtil.toJSONString(hashMap2));
//		reqWebBillGetDTO.setCustomerCode("月结卡号");

        //公司编号 产品编号 顺丰用
        reqWebBillGetDTO.setBrandCode("SF");
        reqWebBillGetDTO.setProductCode("2");

        //是否上门取件 发货时间
        reqWebBillGetDTO.setCallDoorPickUp(false);
        reqWebBillGetDTO.setDoorPickUpTime(null);
        reqWebBillGetDTO.setDoorPickUpEndTime(null);

        ResponseBaseDTO.WayBillGetResponseEntityDTO result = this.normalTest(this.doPostJson(ROOT_PATH, "/webBillGet", reqWebBillGetDTO), ResponseBaseDTO.WayBillGetResponseEntityDTO.class);
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.print("获取电子面单号接口测试结果：");
        System.out.println(result);
    }

    @Test
    @DisplayName("获得打印机指令")
    public void getCloudPrintCMD() throws Exception {
        ReqBlueToothCloudPrintEntityDTO toothCloudPrintDTO = new ReqBlueToothCloudPrintEntityDTO();
        //客户端id 客户端类型
        toothCloudPrintDTO.setClientId("xxxx");
        toothCloudPrintDTO.setClientType("native");
        //打印机名称
        toothCloudPrintDTO.setPrinterName("打印机下面印的型号");
        DocumentEntityDTO document = new DocumentEntityDTO();
        List<RenderContentEntityDTO> renderContentDTOS = new ArrayList<>();
        //打印的数据是从取号来的
        RenderContentEntityDTO renderContentDTO = new RenderContentEntityDTO();
        renderContentDTO.setTemplateUrl("https://cloudprint.cainiao.com/template/standard/474941/27");
        renderContentDTO.setEncrypted(true);
        renderContentDTO.setVer("waybill_print_secret_version_1");
        renderContentDTO.setSignature("签名");
        renderContentDTO.setPrintData("加密的打印内容");
        renderContentDTOS.add(renderContentDTO);
        document.setContents(renderContentDTOS);
        toothCloudPrintDTO.setDocument(document);
        //请求id
        toothCloudPrintDTO.setRequestId("xxxx+随机数");
        ResponseBaseDTO.BlueToothCloudPrintResponseEntityDTO responseDTO = this.normalTest(
                this.doPostJson(ROOT_PATH, "/bluetoothPrint", toothCloudPrintDTO), ResponseBaseDTO.BlueToothCloudPrintResponseEntityDTO.class);
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.print("获取电子面单打印指令测试结果：");
        System.out.println(responseDTO);
    }

    
    @Test
    @DisplayName("获得电子面单充值记录")
    public void getRechargeRecord() throws Exception {
        ReqRechargeRecordEntityDTO reqRechargeRecordDTO = new ReqRechargeRecordEntityDTO();
        ResponseBaseDTO.RechargeRecordResponseEntityDTO recordResponseDTO = this.normalTest(
                this.doPostJson(ROOT_PATH, "/webPrintRechargeRecord", reqRechargeRecordDTO), ResponseBaseDTO.RechargeRecordResponseEntityDTO.class);
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.print("获取电子面单充值记录测试结果：");
        System.out.println(recordResponseDTO);
    }

    protected MockHttpServletRequestBuilder doPostJson(String root, String url, Object entity, Object... uriVars)
            throws JsonProcessingException {
        return post(root + "/" + url, uriVars).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(entity));
    }

    protected <T> T normalTest(MockHttpServletRequestBuilder builder, Class<T> cls) throws Exception {
        MvcResult result = normalTest(builder);
        String res = result.getResponse().getContentAsString();
        if (StringUtils.isNotBlank(res)) {
            this.assertResponseModel(res);
            return objectMapper.readValue(res, cls);
        }
        return null;
    }

    protected MvcResult normalTest(MockHttpServletRequestBuilder builder) throws Exception {
        return this.mockMvc.perform(builder).andDo(MockMvcResultHandlers.print()).andReturn();
    }

    @BeforeEach
    public void setup() {

        // 定义默认mvc build
        DefaultMockMvcBuilder defaultMockMvcBuilder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.setFilter(defaultMockMvcBuilder);
        defaultMockMvcBuilder.alwaysExpect(MockMvcResultMatchers.status().isOk());
        this.mockMvc = defaultMockMvcBuilder.build();

        // 定义验证exception mvc build
        DefaultMockMvcBuilder exceptionMockMvcBuilder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.setFilter(exceptionMockMvcBuilder);
        this.mockMvcException = exceptionMockMvcBuilder.build();
    }

    private void setFilter(DefaultMockMvcBuilder defaultMockMvcBuilder) {
        // 字符过滤
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        defaultMockMvcBuilder.addFilters(encodingFilter);
    }

    protected void assertResponseModel(String res) throws Exception {
        if (tryList(res)) {
            return;
        }
        this.tryResponseModel(res);
    }

    private boolean tryList(String res) {
        try {
            objectMapper.readValue(res, List.class);
        } catch (Exception ignored) {
            return false;
        }
        return true;
    }

    private void tryResponseModel(String res) {
        try {
            ResponseDTO model = objectMapper.readValue(res, ResponseDTO.class);
            Assertions.assertNotNull(model);
            Assertions.assertEquals(model.getCode(), ResponseCode.SUCCESS.getCode());
        } catch (Exception ignored) {
        }
    }
}
