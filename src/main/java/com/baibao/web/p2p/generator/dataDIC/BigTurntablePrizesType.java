package com.baibao.web.p2p.generator.dataDIC;

import java.util.ArrayList;
import java.util.List;



public enum BigTurntablePrizesType {
	//奖品编号,奖品名称,奖品金额,奖品区间类型,奖品概率,奖品类型,奖品使用规则
	/**
	 * 奖品区间1(投资总额＜5000)
	 */
	oneIntervalItemOne(11,"iPhoneSE",0,1,0,1,0),
	oneIntervalItemTwo(1,"1888元阿芙护肤品组合",0,1,0,1,0),
	oneIntervalItemThree(9,"188元红酒",0,1,0.001,1,0),
	oneIntervalItemFour(6,"79元健康手环",0,1,0.0001,1,0),
	oneIntervalItemFive(3,"69元充电宝",0,1,0.0001,1,0),
	oneIntervalItemSix(7,"60元红包",60,1,0.04,2,50000),
	oneIntervalItemSeven(10,"30元红包",30,1,0.07,2,10000),
	oneIntervalItemEight(4,"20元红包",20,1,0.07,2,5000),
	oneIntervalItemNine(2,"10元红包",10,1,0.02,2,1000),
	oneIntervalItemTen(0,"1元红包",1,1,0.01,2,100),
	oneIntervalItemEleven(5,"再来一次",0,1,0.1488,3,0),
	oneIntervalItemTwelve(8,"谢谢参与",0,1,0.6,0,0),
	
	/**
	 * 奖品区间2(投资总额≥5000＜30000)
	 */
	/*twoIntervalItemOne(11,"iPhoneSE",0,2,0,1,0),
	twoIntervalItemTwo(1,"1888元阿芙护肤品组合",0,2,0,1,0),
	twoIntervalItemThree(9,"188元红酒",0,2,0.01,1,0),
	twoIntervalItemFour(6,"79元健康手环",0,2,0.001,1,0),
	twoIntervalItemFive(3,"69元充电宝",0,2,0.002,1,0),
	twoIntervalItemSix(7,"60元红包",60,2,0.03,2,50000),
	twoIntervalItemSeven(10,"30元红包",30,2,0.05,2,10000),
	twoIntervalItemEight(4,"20元红包",20,2,0.03,2,5000),
	twoIntervalItemNine(2,"10元红包",10,2,0.015,2,1000),
	twoIntervalItemTen(0,"1元红包",1,2,0.01,2,100),
	twoIntervalItemEleven(5,"再来一次",0,2,0.152,3,0),
	twoIntervalItemTwelve(8,"谢谢参与",0,2,0.7,0,0),*/
	twoIntervalItemOne(11,"iPhoneSE",0,2,0,1,0),
	twoIntervalItemTwo(1,"1888元阿芙护肤品组合",0,2,0,1,0),
	twoIntervalItemThree(9,"188元红酒",0,2,0.01,1,0),
	twoIntervalItemFour(6,"79元健康手环",0,2,0.001,1,0),
	twoIntervalItemFive(3,"69元充电宝",0,2,0.002,1,0),
	twoIntervalItemSix(7,"60元红包",60,2,0.08,2,50000),
	twoIntervalItemSeven(10,"30元红包",30,2,0.10,2,10000),
	twoIntervalItemEight(4,"20元红包",20,2,0.08,2,5000),
	twoIntervalItemNine(2,"10元红包",10,2,0.015,2,1000),
	twoIntervalItemTen(0,"1元红包",1,2,0.01,2,100),
	twoIntervalItemEleven(5,"再来一次",0,2,0.152,3,0),
	twoIntervalItemTwelve(8,"谢谢参与",0,2,0.55,0,0),
	
	/**
	 * 奖品区间3(投资总额≥30000＜100000)
	 */
	/*threeIntervalItemOne(11,"iPhoneSE",0,3,0,1,0),
	threeIntervalItemTwo(1,"1888元阿芙护肤品组合",0,3,0,1,0),
	threeIntervalItemThree(9,"188元红酒",0,3,0.01,1,0),
	threeIntervalItemFour(6,"79元健康手环",0,3,0.002,1,0),
	threeIntervalItemFive(3,"69元充电宝",0,3,0.004,1,0),
	threeIntervalItemSix(7,"60元红包",60,3,0.03,2,50000),
	threeIntervalItemSeven(10,"30元红包",30,3,0.05,2,10000),
	threeIntervalItemEight(4,"20元红包",20,3,0.05,2,5000),
	threeIntervalItemNine(2,"10元红包",10,3,0.01,2,1000),
	threeIntervalItemTen(0,"1元红包",1,3,0,2,100),
	threeIntervalItemEleven(5,"再来一次",0,3,0.144,3,0),
	threeIntervalItemTwelve(8,"谢谢参与",0,3,0.7,0,0),*/
	threeIntervalItemOne(11,"iPhoneSE",0,3,0,1,0),
	threeIntervalItemTwo(1,"1888元阿芙护肤品组合",0,3,0,1,0),
	threeIntervalItemThree(9,"188元红酒",0,3,0.01,1,0),
	threeIntervalItemFour(6,"79元健康手环",0,3,0.002,1,0),
	threeIntervalItemFive(3,"69元充电宝",0,3,0.004,1,0),
	threeIntervalItemSix(7,"60元红包",60,3,0.10,2,50000),
	threeIntervalItemSeven(10,"30元红包",30,3,0.09,2,10000),
	threeIntervalItemEight(4,"20元红包",20,3,0.08,2,5000),
	threeIntervalItemNine(2,"10元红包",10,3,0.01,2,1000),
	threeIntervalItemTen(0,"1元红包",1,3,0.01,2,100),
	threeIntervalItemEleven(5,"再来一次",0,3,0.144,3,0),
	threeIntervalItemTwelve(8,"谢谢参与",0,3,0.55,0,0),
	
	/**
	 * 奖品区间4(投资总额≥100000＜500000)
	 */
	/*fourIntervalItemOne(11,"iPhoneSE",0,4,0,1,0),
	fourIntervalItemTwo(1,"1888元阿芙护肤品组合",0,4,0,1,0),
	fourIntervalItemThree(9,"188元红酒",0,4,0.015,1,0),
	fourIntervalItemFour(6,"79元健康手环",0,4,0.006,1,0),
	fourIntervalItemFive(3,"69元充电宝",0,4,0.007,1,0),
	fourIntervalItemSix(7,"60元红包",60,4,0.05,2,50000),
	fourIntervalItemSeven(10,"30元红包",30,4,0.05,2,10000),
	fourIntervalItemEight(4,"20元红包",20,4,0.02,2,5000),
	fourIntervalItemNine(2,"10元红包",10,4,0,2,1000),
	fourIntervalItemTen(0,"1元红包",1,4,0,2,100),
	fourIntervalItemEleven(5,"再来一次",0,4,0.152,3,0),
	fourIntervalItemTwelve(8,"谢谢参与",0,4,0.7,0,0),*/
	fourIntervalItemOne(11,"iPhoneSE",0,4,0,1,0),
	fourIntervalItemTwo(1,"1888元阿芙护肤品组合",0,4,0,1,0),
	fourIntervalItemThree(9,"188元红酒",0,4,0.015,1,0),
	fourIntervalItemFour(6,"79元健康手环",0,4,0.006,1,0),
	fourIntervalItemFive(3,"69元充电宝",0,4,0.007,1,0),
	fourIntervalItemSix(7,"60元红包",60,4,0.12,2,50000),
	fourIntervalItemSeven(10,"30元红包",30,4,0.1,2,10000),
	fourIntervalItemEight(4,"20元红包",20,4,0.04,2,5000),
	fourIntervalItemNine(2,"10元红包",10,4,0.01,2,1000),
	fourIntervalItemTen(0,"1元红包",1,4,0,2,100),
	fourIntervalItemEleven(5,"再来一次",0,4,0.152,3,0),
	fourIntervalItemTwelve(8,"谢谢参与",0,4,0.55,0,0),
	
	/**
	 * 奖品区间5(投资总额≥500000)
	 */
	sixIntervalItemOne(11,"iPhoneSE",0,5,0,1,0),
	sixIntervalItemTwo(1,"1888元阿芙护肤品组合",0,5,0.01,1,0),
	sixIntervalItemThree(9,"188元红酒",0,5,0.03,1,0),
	sixIntervalItemFour(6,"79元健康手环",0,5,0.010,1,0),
	sixIntervalItemFive(3,"69元充电宝",0,5,0.020,1,0),
	sixIntervalItemSix(7,"60元红包",60,5,0.06,2,50000),
	sixIntervalItemSeven(10,"30元红包",30,5,0.12,2,10000),
	sixIntervalItemEight(4,"20元红包",20,5,0.04,2,5000),
	sixIntervalItemNine(2,"10元红包",10,5,0,2,1000),
	sixIntervalItemTen(0,"1元红包",1,5,0,2,100),
	sixIntervalItemEleven(5,"再来一次",0,5,0.11,3,0),
	sixIntervalItemTwelve(8,"谢谢参与",0,5,0.6,0,0);
	/**
	 * 奖品编号
	 */
	public int prizesNo;
	/**
	 * 奖品名称
	 */
	public String prizesName;
	/**
	 * 奖品金额
	 */
	public Integer prizesMoney; 
	/**
	 * 奖品区间类型
	 */
	public int intervalType;
	/**
	 * 奖品概率(区间不同概率不同)	  
	 */
	public double probability;
	
	/**
	 * 奖品类型(0：谢谢参与1:实物奖品2：红包奖品3：再来一次)
	 */
	public int prizesType;
	
	/**
	 * 红包使用规则
	 */
	public Integer serviceRegulations;
	
	private BigTurntablePrizesType(int prizesNo,String prizesName,Integer prizesMoney,int intervalType,double probability,int prizesType,Integer serviceRegulations) {
		this.prizesNo = prizesNo;
		this.prizesName = prizesName;
		this.prizesMoney = prizesMoney;
		this.intervalType = intervalType;
		this.probability = probability;
		this.prizesType = prizesType;
		this.serviceRegulations = serviceRegulations;
	}
	
	/**
	 * 根据奖品区间类型返回不同区间类型的奖品
	 * @param intervalType
	 * @return
	 */
	public static List<BigTurntablePrizesType> getBigTurntablePrizesTypeList(int intervalType){
		List<BigTurntablePrizesType> bigTurntablePrizesTypeList = new ArrayList<BigTurntablePrizesType>();
		if(intervalType != 0){
			for (BigTurntablePrizesType bigTurntablePrizesType : BigTurntablePrizesType.values()) {
				if(bigTurntablePrizesType.getIntervalType() == intervalType){
					bigTurntablePrizesTypeList.add(bigTurntablePrizesType);
				}
			}
		}
		return bigTurntablePrizesTypeList;
	}
	
	/**
	 * 根据奖品区间和奖品编号返回奖品
	 * @param prizesNo
	 * @param intervalType
	 * @return
	 */
	public static BigTurntablePrizesType getPrize(int prizesNo,int intervalType){
		if(intervalType != 0 && intervalType != 0){
			for (BigTurntablePrizesType bigTurntablePrizesType : BigTurntablePrizesType.values()) {
				if(bigTurntablePrizesType.getIntervalType() == intervalType && bigTurntablePrizesType.getPrizesNo() ==prizesNo ){
					return bigTurntablePrizesType;
				}
			}
		}
		return null;
	}

	public int getPrizesNo() {
		return prizesNo;
	}

	public void setPrizesNo(int prizesNo) {
		this.prizesNo = prizesNo;
	}

	public String getPrizesName() {
		return prizesName;
	}

	public void setPrizesName(String prizesName) {
		this.prizesName = prizesName;
	}

	public Integer getPrizesMoney() {
		return prizesMoney;
	}

	public void setPrizesMoney(Integer prizesMoney) {
		this.prizesMoney = prizesMoney;
	}

	public int getIntervalType() {
		return intervalType;
	}

	public void setIntervalType(int intervalType) {
		this.intervalType = intervalType;
	}

	public int getPrizesType() {
		return prizesType;
	}

	public void setPrizesType(int prizesType) {
		this.prizesType = prizesType;
	}

	public Integer getServiceRegulations() {
		return serviceRegulations;
	}

	public void setServiceRegulations(Integer serviceRegulations) {
		this.serviceRegulations = serviceRegulations;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}
	
}
