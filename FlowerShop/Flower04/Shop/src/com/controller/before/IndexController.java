package com.controller.before;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.PayDao;
import com.service.before.IndexService;

import jdk.nashorn.internal.ir.Flags;
@Controller
public class IndexController {
	@Autowired
	private IndexService indexService;
	@Autowired
	private PayDao paydao; 
	
	@RequestMapping("/toRegister")//去注册
	public String toRegister(Model model) {
		return indexService.toRegister(model);
	}
	@RequestMapping("/toLogin")//去登录
	public String toLogin(Model model) {
		return indexService.toLogin(model);
	}

//	@RequestMapping("/cart/selectCart")//鐠愵厾澧挎潪锔惧仯閸戞槒鐑︽潪顒勩�夐棃锟�
//	public String cart(Model model) {
//		return "cart";
//	}
	
	@RequestMapping("/goodsDetail")//鏉╂柨娲栭懞杈╂畱鐠囷附鍎忛惃鍕�夐棃锟�
	public String goodsDetail(Model model,Integer id) {
		return indexService.goodsDetail(model, id);
	}
	
	//瑜版挾鍋ｉ崙璇插彆閸涘﹥鐖稉濠勬畱閸忣剙鎲￠惃鍕閸婃瑤绱伴崥鎴濆缁旑垵绻戦崶鐐垫祲鎼存梻娈戦弫鐗堝祦
	@RequestMapping(value="/selectANotice/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectANotice(Model model,@PathVariable Integer id) {
		Map<String, Object> map = new HashMap<>();
		map.put("notice",indexService.selectANotice(model, id));
		return map;
	}
	
	//娑撳銆夐棃銏ｎ嚞濮癸拷
	@RequestMapping("/index2")
	public String index2(Model model) {
		return indexService.index2(model);
	}
	
	//閺屻儴顕楁い鐢告桨
	@RequestMapping("/search2/{currentIndex}")
	public String search2(Model model,@PathVariable int currentIndex) {
		return indexService.search2(model, currentIndex);
	}
	//閺嶈宓侀幖婊呭偍濡楀棔鑵戦惃鍕繆閹垱鐓＄拠銏㈡祲閸忓厖淇婇幁锟�
	@RequestMapping(value= "/search/{mykey}",method=RequestMethod.GET)
	public String search(Model model,@PathVariable String mykey) {
		return indexService.search(model, mykey);
	}
	//閻戭參鏀㈤崯鍡楁惂閺囨潙顦块弫鐗堝祦
	@RequestMapping("/search/more/hot/{currentIndex}")
	public String search_type(Model model,@PathVariable int currentIndex) {
		return indexService.getInfobyhot(model,currentIndex);
	}
	//娴滅儤鐨甸崯鍡楁惂閺囨潙顦块弫鐗堝祦
	@RequestMapping("search/more/popularity/{currentIndex}")
	public String search_popularity(Model model,@PathVariable int currentIndex) {
		return indexService.getInfobypopularity(model,currentIndex);
	}

	//閹兼粎鍌ㄦい鐢告桨閿涘本鐗撮幑顔煎缁旑垯绱堕柅鎺旂舶閸氬海顏惃鍕蒋娴犺埖鏆熼幑顔跨箻鐞涘本鐓＄拠銏ｇ箲閸ワ拷
	@RequestMapping(value="/selectInfo/{search_type}/{search_sale}/{search_method}/{currentIndex}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectInfo(Model model,@PathVariable Integer search_type,@PathVariable String search_sale,@PathVariable String search_method,@PathVariable int currentIndex) {
		return indexService.selectInfo(model, search_type, search_sale, search_method,currentIndex);
	
	}
	//閻€劍鍩涙稉顓炵妇
	@RequestMapping("/useC")
	public String userCenter() {
		return "redirect:/userCenter";
	}
	//鐐瑰嚮鏀粯涔嬪悗鍒涘缓鐨勮鍗曢〉闈�
	@RequestMapping("/orderD/{orderId}")
	public String selectorderDetail(Model model,@PathVariable Integer orderId) {
		return indexService.getOrderDetail(model,orderId);
	}
	
	@RequestMapping("/orderD")
	public String orderDetail() {
		return "before/orderDetail";
	}
	//鑾峰彇褰撳墠鐢ㄦ埛鐨勭浉鍏冲湴鍧�
	@RequestMapping("/getAddressInfo")
	@ResponseBody
	public Map<String, Object> getAddress(HttpServletRequest request) {
		return indexService.getAddress(request);
	}
	@RequestMapping("/pay")
	public String pay() {
		return "before/pay";
	}
	@RequestMapping("/order/pay/{orderId}")
	public String orderpay(Model model,@PathVariable int orderId) {
		return indexService.orderPay(model, orderId);
	}
	@RequestMapping("/weChatpaid/{orderId}/{amount}")
	public String weChatPay(Model model,@PathVariable int orderId,@PathVariable Float amount) {
		Map<String, Object> map = new HashMap<>();
		model.addAttribute("orderId", orderId);
		model.addAttribute("amount", amount);
		map.put("id", orderId);
		map.put("payway", "微信");
		paydao.updateOrder(map);
		return "before/weChatSuccessed";
	}
}
