package com.baibao.web.p2p.comm;

import java.io.File;

/**
 * 常量类
 * 用来记录一般常用的常量,例如 操作session时，频繁使用的一些key
 *
 */
public class Const {
	
	/**
	 * 返回码
	 * 消息常量
	 * 返回类型
	 */
	public static final String retMsg = "retMsg";
	public static final String retCode = "retCode";
	public static final String retType = "retType";
	
	/**
	 * 操作成功、失败
	 */
	public static final Integer successOperation = 0;    
	public static final Integer errorOperation = 1;
	
	/**
	 * 当前登录用户
	 */
	public static final String CURRENT_LOGIN_USER = "CURRENT_LOGIN_USER";
	
	/**
	 * 当前登录用户认证信息
	 */
	public static final String CURRENT_LOGIN_USER_AUTH = "CURRENT_LOGIN_USER_AUTH";
	
	/**
	 * 当前登录的用户所使用的平台账户
	 */
	public static final String CURRENT_LOGIN_PLATACCOUNT = "CURRENT_LOGIN_PLATACCOUNT";
	
	/**
	 * 当前登录的用户的安全信息
	 */
	public static final String CURRENT_LOGIN_SECUREINFO = "CURRENT_LOGIN_SECUREINFO";
	
	/**
	 * 当前登录的用户的基本信息
	 */
	public static final String CURRENT_LOGIN_BASEINFO = "CURRENT_LOGIN_BASEINFO";
	
	/**
	 * 当前登录的员工账号
	 */
	public static final String CURRENT_LOGIN_EMPLOYEE = "CURRENT_LOGIN_EMPLOYEE";
	
	public static final String CURRENT_LOGIN_USER_NICKNAME="CURRENT_LOGIN_USER_NICKNAME";
	
	/**
	 * 验证码session中的key
	 */
	public static final String  SCAPTCHA="SCAPTCHA";

	public static final String  ApplySuccess="APPLY_SUCCESS";
	/**
	 * 缓存支付推进ticket key值
	 */
	public static final String  pay_tciket="BINDINGPAY_TICKET_";
	
	
	/**
	 * 订单状态
	 */
	public static final String success = "00";//成功
	public static final String fail = "01";//失败
	public static final String processing = "02";//处理中
	public static final String pending = "04";//待处理
	
	/**
	 * public_order
	 */
	public static final String recharge = "10"; // 充值
	public static final String withdrawals = "11";// 提现
	public static final String tender = "12";// 投资
	public static final String profit = "40";// 收益
	public static final String loan = "50"; //放款 
	public static final String repayment = "51";//还款
	public static final String fee = "52";//手续费

	/**
	 * 充值类型
	 */
	public static final String bindingRecharge = "deposit";//快捷支付
	public static final String onlineBankingRecharge = "recharge";//网银支付

	/** 产品类型-抵押保证标 */
	public static final String dybzProductTypeNo = "1";
	/** 产品类型-债券转让标 */
	public static final String zqzrProductTypeNo = "2";
	/** 产品类型-信用标 */
	public static final String creditProductTypeNo = "3";
	
	/**
	 * 产品活动类型
	 */
	public static final String activityType ="1" ;//新手专项
	/**
	 * 产品状态
	 */
	public static final String tobeOpen ="0";//待开放
	public static final String openTender ="1";//开放投标
	public static final String fullMark ="2";//已满标
	public static final String flowStandard ="3";//流标
	public static final String repaymentIn ="4";//还款中
	public static final String hasEnden ="5";//已结束
	public static final String haveDebt = "6";//已债转
	public static final String inDebt = "7";//债转中
 
	/**
	 * 投资类型:1:直投标2：债转标
	 */
	public static final int DIRECTBIDDING = 1;//直投标
	public static final int IFTHESTANDARD  = 2;//债转标
	public static final int ASSETSPACK = 3;//资产包
	public static final int LIMITEDDAYS = 4;//佰日鑫
	
	/**
	 * 还款方式
	 */
	public static final int AVERAGECAPITALPLUSINTEREST  = 0;//等额本息
	public static final int THEINTERESTRATEAFTERTHEFIRST  = 1;//先息后本
	public static final int THEINTERESTPAIDBYTHEDAY = 2;//按天计息
	public static final int AVERAGECAPITAL = 3;//等额本金
	public static final int Terminability = 4;//一次性还本付息
	public static final int TerminabilityDays = 5;//按日计息的一次性还本付息
	
	
	/**
	 * 产品申请方式
	 */
	public static final String externalApplication ="10";//10 外部申请
	public static final String InternalStandard ="11";//11内部发标
	
	/**
	 * 产品申请人类型
	 */
	public static final String personalApply ="1";// 1：个人
	public static final String enterpriseApply ="2";//2：企业
	
	
	/**
	 * 企业产品申请是否有其他贷款
	 */
	public static final String otherLoansYes ="1";//1:有
	public static final String otherLoansNo ="2";//2：无
	
	
	/**
	 * 文章类型
	 */
	public static final String media = "1";// 媒体报道
	public static final String notice = "2";//网站公告
	public static final String trends = "3";// 最新动态
	
	/**
	 * 交易订单号前缀
	 */
	public static final String CZ = "1001";// 充值
	public static final String TX = "1002";// 提现
	public static final String TZ = "1003";// 投资
	
	/**
	 * 首页图片类型
	 */
	public static final String pc = "1";
	public static final String app = "2";
	public static final String h5 = "3";
	
	/**
	 * 认证状态
	 */
	public static final String ALREADYCERTIFIED = "0";//已认证
	public static final String NOTCERTIFIED = "1";//未认证
	
	/**
	 * 绑卡推进状态
	 */
	public static final String NOTADVANCING  = "00";//未推进
	public static final String ALREADYADVANCE = "01";//已推进
	
	
	
	/**
	 * 新浪支付会员网关和收单网关配置名
	 */
	public static final String SINA_PAY_GATWAY4MEMBER = "SINA_PAY_GATWAY4MEMBER";
	public static final String SINA_PAY_GATWAY4ACQUIRING = "SINA_PAY_GATWAY4ACQUIRING";
	
	/**
	 * 存储验证码发送时间key
	 */
	public static final String SEND_VALIDATE_CODE_DATE = "sendvalidatetime";
	/**
	 * redis存放平台注册总人数key值
	 */
	public static final String PLATFORM_REGISTER_USER = "PLATFORM_REGISTER_USER";
	/**
	 * redis存放平台投资总额key值
	 */
	public static final String PLATFORM_TENDER_AMOUNT_TOTAL = "PLATFORM_TENDER_AMOUNT_TOTAL";
	/**
	 * redis存放平台收益总额key值
	 */
	public static final String PLATFORM_PROFIT_AMOUNT_TOTAL = "PLATFORM_PROFIT_AMOUNT_TOTAL";
	/**
	 * redis存放平台交易总笔数
	 */
	public static final String PLATFORM_TRADE_COUNT_TOTAL = "PLATFORM_TRADE_COUNT_TOTAL";
	/**
	 * redis存放平台逾期总笔数
	 */
	public static final String PLATFORM_OVERDUE_COUNT_TOTAL = "PLATFORM_OVERDUE_COUNT_TOTAL";
	/**
	 * redis存放平台出借总人数
	 */
	public static final String PLATFORM_TENDER_PEOPLE_COUNT_TOTAL = "PLATFORM_TENDER_PEOPLE_COUNT_TOTAL";
	
	/**
	 * redis首页图片地址缓存
	 */
	public static final String INDEXPICTURE = "indexpicture";
	
	/**
	 *  redis网站公告缓存
	 */
	public static final String ANNOUNCEMENT  = "announcement ";
	
	/**
	 *  redis 7天收益率
	 */
	public static final String YIELDRATE  = "yieldrate ";
	
	/**
	 * 从coreTrans获取唯一流水号类型
	 */        
	public static final String CUST_NO = "100";// 客户号
	public static final String PROJECT_NO = "BBJF";// 标的号
	public static final String PAYMENT_FLOW_NO = "101";// 获取充值流水
	public static final String WITH_DRAW_NO = "102";// 提现流水号
	public static final String CARD_NO = "103";// 绑卡流水号
	public static final String BID_TRANS_R_FLOW_NO = "105";// 投标流水号(对应代收)
	public static final String BID_TRANS_P_FLOW_NO = "106";// 投标流水号(对应代付)
	public static final String ADMIN_TRANS_R_FLOW_NO = "107";// 还款流水号(对应借款人代收)
	public static final String ADMIN_TRANS_P_FLOW_NO = "108";// 还款流水号(对应借款人代付)
	public static final String CREDITOR_TRANS_R_Flow_NO = "109";// 购买债权流水号(对应代收)
	public static final String CREDITOR_TRANS_P_Flow_NO = "110";// 购买债权流水号(对应代付)
	public static final String Comm_TRANS_R_Flow_NO = "201";// 普通转账(对应代收)
	public static final String Comm_TRANS_P_Flow_NO = "202";// 普通转账(对应代付)
	public static final String COMM_ACTIVE_R_FLOW_NO = "203";// 活动转账(对应代收)
	public static final String COMM_ACTIVE_P_FLOW_NO = "204";// 活动转账(对应代付)
	public static final String INVITE_CODE = "BCJT";
    	
	//新浪字段
	/**
	 * 账户类型为 “存钱罐” 账户
	 */
	public static final String  SAVING_POT = "SAVING_POT";
	/**
	 * 用户标识类型
	 */
	public static final String  UID = "UID";
	/**
	 * 认证类型
	 */
	public static final String MOBILE = "MOBILE";
	public static final String EMAIL = "EMAIL";
	/**
	 * 证件类型
	 */
	public static final String IC = "IC";
	/**
	 * app 下载
	 */
	public static final String upload_path_linux = File.separator+"opt"+File.separator+"mobile"+File.separator;//"D:/mobile/";
	/**
	 * app 下载
	 */
	public static final String upload_path_window = "D:"+File.separator+"opt"+File.separator+"mobile"+File.separator;//"D:/mobile/";
	/**
	 * 提现扣款金额
	 */
	public static final String userFee = "0";
	/**
	 * 上线时间
	 */
	public static final String worktime="2016-03-14";
	/**
	 * 二期域名
	 */
	public static final String basePath="https://www.baibaojr.com";
	
	public static final String hetongAddress = "/opt/tomcat8080/logs/loancontract/";
	
	public static final String noLoginMsg = "\u7528\u6237\u672a\u767b\u5f55";  //用户未登录状态返回结果
	//初始化参数
	/**
	 * 关于我们
	 */
	public static final String CONTACTUS = "contactus";
	
	/**
	 * 安全中心
	 */
	public static final String SECURITY = "security";
	/**
	 * 协议范本
	 */
	public static final String CONTRACT = "contract";
	/**
	 * 注册协议
	 */
	public static final String REGISTERAGREEMENT = "registerAgreement";
	/**
	 * 帮助中心
	 */
	public static final String HELPCENTERAPP = "helpCenterApp";
	/**
	 * 电话
	 */
	public static final String TELEPHONE = "telephone";
	/**
	 * 新手引导
	 */
	public static final String BEGINERGUIDE  = "beginerGuide";
	
	
	
	
	
}
