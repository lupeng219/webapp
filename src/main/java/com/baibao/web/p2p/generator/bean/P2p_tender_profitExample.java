package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_tender_profitExample implements Serializable{
    
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_tender_profitExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPtpIdIsNull() {
            addCriterion("ptp_id is null");
            return (Criteria) this;
        }

        public Criteria andPtpIdIsNotNull() {
            addCriterion("ptp_id is not null");
            return (Criteria) this;
        }

        public Criteria andPtpIdEqualTo(Long value) {
            addCriterion("ptp_id =", value, "ptpId");
            return (Criteria) this;
        }

        public Criteria andPtpIdNotEqualTo(Long value) {
            addCriterion("ptp_id <>", value, "ptpId");
            return (Criteria) this;
        }

        public Criteria andPtpIdGreaterThan(Long value) {
            addCriterion("ptp_id >", value, "ptpId");
            return (Criteria) this;
        }

        public Criteria andPtpIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ptp_id >=", value, "ptpId");
            return (Criteria) this;
        }

        public Criteria andPtpIdLessThan(Long value) {
            addCriterion("ptp_id <", value, "ptpId");
            return (Criteria) this;
        }

        public Criteria andPtpIdLessThanOrEqualTo(Long value) {
            addCriterion("ptp_id <=", value, "ptpId");
            return (Criteria) this;
        }

        public Criteria andPtpIdIn(List<Long> values) {
            addCriterion("ptp_id in", values, "ptpId");
            return (Criteria) this;
        }

        public Criteria andPtpIdNotIn(List<Long> values) {
            addCriterion("ptp_id not in", values, "ptpId");
            return (Criteria) this;
        }

        public Criteria andPtpIdBetween(Long value1, Long value2) {
            addCriterion("ptp_id between", value1, value2, "ptpId");
            return (Criteria) this;
        }

        public Criteria andPtpIdNotBetween(Long value1, Long value2) {
            addCriterion("ptp_id not between", value1, value2, "ptpId");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoIsNull() {
            addCriterion("ptp_tenderFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoIsNotNull() {
            addCriterion("ptp_tenderFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoEqualTo(String value) {
            addCriterion("ptp_tenderFlowNo =", value, "ptpTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoNotEqualTo(String value) {
            addCriterion("ptp_tenderFlowNo <>", value, "ptpTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoGreaterThan(String value) {
            addCriterion("ptp_tenderFlowNo >", value, "ptpTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoGreaterThanOrEqualTo(String value) {
            addCriterion("ptp_tenderFlowNo >=", value, "ptpTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoLessThan(String value) {
            addCriterion("ptp_tenderFlowNo <", value, "ptpTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoLessThanOrEqualTo(String value) {
            addCriterion("ptp_tenderFlowNo <=", value, "ptpTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoLike(String value) {
            addCriterion("ptp_tenderFlowNo like", value, "ptpTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoNotLike(String value) {
            addCriterion("ptp_tenderFlowNo not like", value, "ptpTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoIn(List<String> values) {
            addCriterion("ptp_tenderFlowNo in", values, "ptpTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoNotIn(List<String> values) {
            addCriterion("ptp_tenderFlowNo not in", values, "ptpTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoBetween(String value1, String value2) {
            addCriterion("ptp_tenderFlowNo between", value1, value2, "ptpTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtpTenderflownoNotBetween(String value1, String value2) {
            addCriterion("ptp_tenderFlowNo not between", value1, value2, "ptpTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoIsNull() {
            addCriterion("ptp_loanNo is null");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoIsNotNull() {
            addCriterion("ptp_loanNo is not null");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoEqualTo(String value) {
            addCriterion("ptp_loanNo =", value, "ptpLoanno");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoNotEqualTo(String value) {
            addCriterion("ptp_loanNo <>", value, "ptpLoanno");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoGreaterThan(String value) {
            addCriterion("ptp_loanNo >", value, "ptpLoanno");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoGreaterThanOrEqualTo(String value) {
            addCriterion("ptp_loanNo >=", value, "ptpLoanno");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoLessThan(String value) {
            addCriterion("ptp_loanNo <", value, "ptpLoanno");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoLessThanOrEqualTo(String value) {
            addCriterion("ptp_loanNo <=", value, "ptpLoanno");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoLike(String value) {
            addCriterion("ptp_loanNo like", value, "ptpLoanno");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoNotLike(String value) {
            addCriterion("ptp_loanNo not like", value, "ptpLoanno");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoIn(List<String> values) {
            addCriterion("ptp_loanNo in", values, "ptpLoanno");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoNotIn(List<String> values) {
            addCriterion("ptp_loanNo not in", values, "ptpLoanno");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoBetween(String value1, String value2) {
            addCriterion("ptp_loanNo between", value1, value2, "ptpLoanno");
            return (Criteria) this;
        }

        public Criteria andPtpLoannoNotBetween(String value1, String value2) {
            addCriterion("ptp_loanNo not between", value1, value2, "ptpLoanno");
            return (Criteria) this;
        }

        public Criteria andPtpLoanseqIsNull() {
            addCriterion("ptp_loanSeq is null");
            return (Criteria) this;
        }

        public Criteria andPtpLoanseqIsNotNull() {
            addCriterion("ptp_loanSeq is not null");
            return (Criteria) this;
        }

        public Criteria andPtpLoanseqEqualTo(Integer value) {
            addCriterion("ptp_loanSeq =", value, "ptpLoanseq");
            return (Criteria) this;
        }

        public Criteria andPtpLoanseqNotEqualTo(Integer value) {
            addCriterion("ptp_loanSeq <>", value, "ptpLoanseq");
            return (Criteria) this;
        }

        public Criteria andPtpLoanseqGreaterThan(Integer value) {
            addCriterion("ptp_loanSeq >", value, "ptpLoanseq");
            return (Criteria) this;
        }

        public Criteria andPtpLoanseqGreaterThanOrEqualTo(Integer value) {
            addCriterion("ptp_loanSeq >=", value, "ptpLoanseq");
            return (Criteria) this;
        }

        public Criteria andPtpLoanseqLessThan(Integer value) {
            addCriterion("ptp_loanSeq <", value, "ptpLoanseq");
            return (Criteria) this;
        }

        public Criteria andPtpLoanseqLessThanOrEqualTo(Integer value) {
            addCriterion("ptp_loanSeq <=", value, "ptpLoanseq");
            return (Criteria) this;
        }

        public Criteria andPtpLoanseqIn(List<Integer> values) {
            addCriterion("ptp_loanSeq in", values, "ptpLoanseq");
            return (Criteria) this;
        }

        public Criteria andPtpLoanseqNotIn(List<Integer> values) {
            addCriterion("ptp_loanSeq not in", values, "ptpLoanseq");
            return (Criteria) this;
        }

        public Criteria andPtpLoanseqBetween(Integer value1, Integer value2) {
            addCriterion("ptp_loanSeq between", value1, value2, "ptpLoanseq");
            return (Criteria) this;
        }

        public Criteria andPtpLoanseqNotBetween(Integer value1, Integer value2) {
            addCriterion("ptp_loanSeq not between", value1, value2, "ptpLoanseq");
            return (Criteria) this;
        }

        public Criteria andPtpCapitalIsNull() {
            addCriterion("ptp_capital is null");
            return (Criteria) this;
        }

        public Criteria andPtpCapitalIsNotNull() {
            addCriterion("ptp_capital is not null");
            return (Criteria) this;
        }

        public Criteria andPtpCapitalEqualTo(BigDecimal value) {
            addCriterion("ptp_capital =", value, "ptpCapital");
            return (Criteria) this;
        }

        public Criteria andPtpCapitalNotEqualTo(BigDecimal value) {
            addCriterion("ptp_capital <>", value, "ptpCapital");
            return (Criteria) this;
        }

        public Criteria andPtpCapitalGreaterThan(BigDecimal value) {
            addCriterion("ptp_capital >", value, "ptpCapital");
            return (Criteria) this;
        }

        public Criteria andPtpCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ptp_capital >=", value, "ptpCapital");
            return (Criteria) this;
        }

        public Criteria andPtpCapitalLessThan(BigDecimal value) {
            addCriterion("ptp_capital <", value, "ptpCapital");
            return (Criteria) this;
        }

        public Criteria andPtpCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ptp_capital <=", value, "ptpCapital");
            return (Criteria) this;
        }

        public Criteria andPtpCapitalIn(List<BigDecimal> values) {
            addCriterion("ptp_capital in", values, "ptpCapital");
            return (Criteria) this;
        }

        public Criteria andPtpCapitalNotIn(List<BigDecimal> values) {
            addCriterion("ptp_capital not in", values, "ptpCapital");
            return (Criteria) this;
        }

        public Criteria andPtpCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptp_capital between", value1, value2, "ptpCapital");
            return (Criteria) this;
        }

        public Criteria andPtpCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptp_capital not between", value1, value2, "ptpCapital");
            return (Criteria) this;
        }

        public Criteria andPtpInterestIsNull() {
            addCriterion("ptp_interest is null");
            return (Criteria) this;
        }

        public Criteria andPtpInterestIsNotNull() {
            addCriterion("ptp_interest is not null");
            return (Criteria) this;
        }

        public Criteria andPtpInterestEqualTo(BigDecimal value) {
            addCriterion("ptp_interest =", value, "ptpInterest");
            return (Criteria) this;
        }

        public Criteria andPtpInterestNotEqualTo(BigDecimal value) {
            addCriterion("ptp_interest <>", value, "ptpInterest");
            return (Criteria) this;
        }

        public Criteria andPtpInterestGreaterThan(BigDecimal value) {
            addCriterion("ptp_interest >", value, "ptpInterest");
            return (Criteria) this;
        }

        public Criteria andPtpInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ptp_interest >=", value, "ptpInterest");
            return (Criteria) this;
        }

        public Criteria andPtpInterestLessThan(BigDecimal value) {
            addCriterion("ptp_interest <", value, "ptpInterest");
            return (Criteria) this;
        }

        public Criteria andPtpInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ptp_interest <=", value, "ptpInterest");
            return (Criteria) this;
        }

        public Criteria andPtpInterestIn(List<BigDecimal> values) {
            addCriterion("ptp_interest in", values, "ptpInterest");
            return (Criteria) this;
        }

        public Criteria andPtpInterestNotIn(List<BigDecimal> values) {
            addCriterion("ptp_interest not in", values, "ptpInterest");
            return (Criteria) this;
        }

        public Criteria andPtpInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptp_interest between", value1, value2, "ptpInterest");
            return (Criteria) this;
        }

        public Criteria andPtpInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptp_interest not between", value1, value2, "ptpInterest");
            return (Criteria) this;
        }

        public Criteria andPtpProfitIsNull() {
            addCriterion("ptp_profit is null");
            return (Criteria) this;
        }

        public Criteria andPtpProfitIsNotNull() {
            addCriterion("ptp_profit is not null");
            return (Criteria) this;
        }

        public Criteria andPtpProfitEqualTo(BigDecimal value) {
            addCriterion("ptp_profit =", value, "ptpProfit");
            return (Criteria) this;
        }

        public Criteria andPtpProfitNotEqualTo(BigDecimal value) {
            addCriterion("ptp_profit <>", value, "ptpProfit");
            return (Criteria) this;
        }

        public Criteria andPtpProfitGreaterThan(BigDecimal value) {
            addCriterion("ptp_profit >", value, "ptpProfit");
            return (Criteria) this;
        }

        public Criteria andPtpProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ptp_profit >=", value, "ptpProfit");
            return (Criteria) this;
        }

        public Criteria andPtpProfitLessThan(BigDecimal value) {
            addCriterion("ptp_profit <", value, "ptpProfit");
            return (Criteria) this;
        }

        public Criteria andPtpProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ptp_profit <=", value, "ptpProfit");
            return (Criteria) this;
        }

        public Criteria andPtpProfitIn(List<BigDecimal> values) {
            addCriterion("ptp_profit in", values, "ptpProfit");
            return (Criteria) this;
        }

        public Criteria andPtpProfitNotIn(List<BigDecimal> values) {
            addCriterion("ptp_profit not in", values, "ptpProfit");
            return (Criteria) this;
        }

        public Criteria andPtpProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptp_profit between", value1, value2, "ptpProfit");
            return (Criteria) this;
        }

        public Criteria andPtpProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptp_profit not between", value1, value2, "ptpProfit");
            return (Criteria) this;
        }

        public Criteria andPtpFactcapitalIsNull() {
            addCriterion("ptp_factCapital is null");
            return (Criteria) this;
        }

        public Criteria andPtpFactcapitalIsNotNull() {
            addCriterion("ptp_factCapital is not null");
            return (Criteria) this;
        }

        public Criteria andPtpFactcapitalEqualTo(BigDecimal value) {
            addCriterion("ptp_factCapital =", value, "ptpFactcapital");
            return (Criteria) this;
        }

        public Criteria andPtpFactcapitalNotEqualTo(BigDecimal value) {
            addCriterion("ptp_factCapital <>", value, "ptpFactcapital");
            return (Criteria) this;
        }

        public Criteria andPtpFactcapitalGreaterThan(BigDecimal value) {
            addCriterion("ptp_factCapital >", value, "ptpFactcapital");
            return (Criteria) this;
        }

        public Criteria andPtpFactcapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ptp_factCapital >=", value, "ptpFactcapital");
            return (Criteria) this;
        }

        public Criteria andPtpFactcapitalLessThan(BigDecimal value) {
            addCriterion("ptp_factCapital <", value, "ptpFactcapital");
            return (Criteria) this;
        }

        public Criteria andPtpFactcapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ptp_factCapital <=", value, "ptpFactcapital");
            return (Criteria) this;
        }

        public Criteria andPtpFactcapitalIn(List<BigDecimal> values) {
            addCriterion("ptp_factCapital in", values, "ptpFactcapital");
            return (Criteria) this;
        }

        public Criteria andPtpFactcapitalNotIn(List<BigDecimal> values) {
            addCriterion("ptp_factCapital not in", values, "ptpFactcapital");
            return (Criteria) this;
        }

        public Criteria andPtpFactcapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptp_factCapital between", value1, value2, "ptpFactcapital");
            return (Criteria) this;
        }

        public Criteria andPtpFactcapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptp_factCapital not between", value1, value2, "ptpFactcapital");
            return (Criteria) this;
        }

        public Criteria andPtpFactinterestIsNull() {
            addCriterion("ptp_factInterest is null");
            return (Criteria) this;
        }

        public Criteria andPtpFactinterestIsNotNull() {
            addCriterion("ptp_factInterest is not null");
            return (Criteria) this;
        }

        public Criteria andPtpFactinterestEqualTo(BigDecimal value) {
            addCriterion("ptp_factInterest =", value, "ptpFactinterest");
            return (Criteria) this;
        }

        public Criteria andPtpFactinterestNotEqualTo(BigDecimal value) {
            addCriterion("ptp_factInterest <>", value, "ptpFactinterest");
            return (Criteria) this;
        }

        public Criteria andPtpFactinterestGreaterThan(BigDecimal value) {
            addCriterion("ptp_factInterest >", value, "ptpFactinterest");
            return (Criteria) this;
        }

        public Criteria andPtpFactinterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ptp_factInterest >=", value, "ptpFactinterest");
            return (Criteria) this;
        }

        public Criteria andPtpFactinterestLessThan(BigDecimal value) {
            addCriterion("ptp_factInterest <", value, "ptpFactinterest");
            return (Criteria) this;
        }

        public Criteria andPtpFactinterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ptp_factInterest <=", value, "ptpFactinterest");
            return (Criteria) this;
        }

        public Criteria andPtpFactinterestIn(List<BigDecimal> values) {
            addCriterion("ptp_factInterest in", values, "ptpFactinterest");
            return (Criteria) this;
        }

        public Criteria andPtpFactinterestNotIn(List<BigDecimal> values) {
            addCriterion("ptp_factInterest not in", values, "ptpFactinterest");
            return (Criteria) this;
        }

        public Criteria andPtpFactinterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptp_factInterest between", value1, value2, "ptpFactinterest");
            return (Criteria) this;
        }

        public Criteria andPtpFactinterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptp_factInterest not between", value1, value2, "ptpFactinterest");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofitIsNull() {
            addCriterion("ptp_factProfit is null");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofitIsNotNull() {
            addCriterion("ptp_factProfit is not null");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofitEqualTo(BigDecimal value) {
            addCriterion("ptp_factProfit =", value, "ptpFactprofit");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofitNotEqualTo(BigDecimal value) {
            addCriterion("ptp_factProfit <>", value, "ptpFactprofit");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofitGreaterThan(BigDecimal value) {
            addCriterion("ptp_factProfit >", value, "ptpFactprofit");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ptp_factProfit >=", value, "ptpFactprofit");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofitLessThan(BigDecimal value) {
            addCriterion("ptp_factProfit <", value, "ptpFactprofit");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ptp_factProfit <=", value, "ptpFactprofit");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofitIn(List<BigDecimal> values) {
            addCriterion("ptp_factProfit in", values, "ptpFactprofit");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofitNotIn(List<BigDecimal> values) {
            addCriterion("ptp_factProfit not in", values, "ptpFactprofit");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptp_factProfit between", value1, value2, "ptpFactprofit");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptp_factProfit not between", value1, value2, "ptpFactprofit");
            return (Criteria) this;
        }

        public Criteria andPtpProfittimeIsNull() {
            addCriterion("ptp_profitTime is null");
            return (Criteria) this;
        }

        public Criteria andPtpProfittimeIsNotNull() {
            addCriterion("ptp_profitTime is not null");
            return (Criteria) this;
        }

        public Criteria andPtpProfittimeEqualTo(Date value) {
            addCriterion("ptp_profitTime =", value, "ptpProfittime");
            return (Criteria) this;
        }

        public Criteria andPtpProfittimeNotEqualTo(Date value) {
            addCriterion("ptp_profitTime <>", value, "ptpProfittime");
            return (Criteria) this;
        }

        public Criteria andPtpProfittimeGreaterThan(Date value) {
            addCriterion("ptp_profitTime >", value, "ptpProfittime");
            return (Criteria) this;
        }

        public Criteria andPtpProfittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ptp_profitTime >=", value, "ptpProfittime");
            return (Criteria) this;
        }

        public Criteria andPtpProfittimeLessThan(Date value) {
            addCriterion("ptp_profitTime <", value, "ptpProfittime");
            return (Criteria) this;
        }

        public Criteria andPtpProfittimeLessThanOrEqualTo(Date value) {
            addCriterion("ptp_profitTime <=", value, "ptpProfittime");
            return (Criteria) this;
        }

        public Criteria andPtpProfittimeIn(List<Date> values) {
            addCriterion("ptp_profitTime in", values, "ptpProfittime");
            return (Criteria) this;
        }

        public Criteria andPtpProfittimeNotIn(List<Date> values) {
            addCriterion("ptp_profitTime not in", values, "ptpProfittime");
            return (Criteria) this;
        }

        public Criteria andPtpProfittimeBetween(Date value1, Date value2) {
            addCriterion("ptp_profitTime between", value1, value2, "ptpProfittime");
            return (Criteria) this;
        }

        public Criteria andPtpProfittimeNotBetween(Date value1, Date value2) {
            addCriterion("ptp_profitTime not between", value1, value2, "ptpProfittime");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofittimeIsNull() {
            addCriterion("ptp_factProfitTime is null");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofittimeIsNotNull() {
            addCriterion("ptp_factProfitTime is not null");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofittimeEqualTo(Date value) {
            addCriterion("ptp_factProfitTime =", value, "ptpFactprofittime");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofittimeNotEqualTo(Date value) {
            addCriterion("ptp_factProfitTime <>", value, "ptpFactprofittime");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofittimeGreaterThan(Date value) {
            addCriterion("ptp_factProfitTime >", value, "ptpFactprofittime");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ptp_factProfitTime >=", value, "ptpFactprofittime");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofittimeLessThan(Date value) {
            addCriterion("ptp_factProfitTime <", value, "ptpFactprofittime");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofittimeLessThanOrEqualTo(Date value) {
            addCriterion("ptp_factProfitTime <=", value, "ptpFactprofittime");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofittimeIn(List<Date> values) {
            addCriterion("ptp_factProfitTime in", values, "ptpFactprofittime");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofittimeNotIn(List<Date> values) {
            addCriterion("ptp_factProfitTime not in", values, "ptpFactprofittime");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofittimeBetween(Date value1, Date value2) {
            addCriterion("ptp_factProfitTime between", value1, value2, "ptpFactprofittime");
            return (Criteria) this;
        }

        public Criteria andPtpFactprofittimeNotBetween(Date value1, Date value2) {
            addCriterion("ptp_factProfitTime not between", value1, value2, "ptpFactprofittime");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeIsNull() {
            addCriterion("ptp_profitType is null");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeIsNotNull() {
            addCriterion("ptp_profitType is not null");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeEqualTo(String value) {
            addCriterion("ptp_profitType =", value, "ptpProfittype");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeNotEqualTo(String value) {
            addCriterion("ptp_profitType <>", value, "ptpProfittype");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeGreaterThan(String value) {
            addCriterion("ptp_profitType >", value, "ptpProfittype");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeGreaterThanOrEqualTo(String value) {
            addCriterion("ptp_profitType >=", value, "ptpProfittype");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeLessThan(String value) {
            addCriterion("ptp_profitType <", value, "ptpProfittype");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeLessThanOrEqualTo(String value) {
            addCriterion("ptp_profitType <=", value, "ptpProfittype");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeLike(String value) {
            addCriterion("ptp_profitType like", value, "ptpProfittype");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeNotLike(String value) {
            addCriterion("ptp_profitType not like", value, "ptpProfittype");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeIn(List<String> values) {
            addCriterion("ptp_profitType in", values, "ptpProfittype");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeNotIn(List<String> values) {
            addCriterion("ptp_profitType not in", values, "ptpProfittype");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeBetween(String value1, String value2) {
            addCriterion("ptp_profitType between", value1, value2, "ptpProfittype");
            return (Criteria) this;
        }

        public Criteria andPtpProfittypeNotBetween(String value1, String value2) {
            addCriterion("ptp_profitType not between", value1, value2, "ptpProfittype");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoIsNull() {
            addCriterion("ptp_custNo is null");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoIsNotNull() {
            addCriterion("ptp_custNo is not null");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoEqualTo(String value) {
            addCriterion("ptp_custNo =", value, "ptpCustno");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoNotEqualTo(String value) {
            addCriterion("ptp_custNo <>", value, "ptpCustno");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoGreaterThan(String value) {
            addCriterion("ptp_custNo >", value, "ptpCustno");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoGreaterThanOrEqualTo(String value) {
            addCriterion("ptp_custNo >=", value, "ptpCustno");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoLessThan(String value) {
            addCriterion("ptp_custNo <", value, "ptpCustno");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoLessThanOrEqualTo(String value) {
            addCriterion("ptp_custNo <=", value, "ptpCustno");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoLike(String value) {
            addCriterion("ptp_custNo like", value, "ptpCustno");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoNotLike(String value) {
            addCriterion("ptp_custNo not like", value, "ptpCustno");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoIn(List<String> values) {
            addCriterion("ptp_custNo in", values, "ptpCustno");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoNotIn(List<String> values) {
            addCriterion("ptp_custNo not in", values, "ptpCustno");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoBetween(String value1, String value2) {
            addCriterion("ptp_custNo between", value1, value2, "ptpCustno");
            return (Criteria) this;
        }

        public Criteria andPtpCustnoNotBetween(String value1, String value2) {
            addCriterion("ptp_custNo not between", value1, value2, "ptpCustno");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusIsNull() {
            addCriterion("ptp_profitstatus is null");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusIsNotNull() {
            addCriterion("ptp_profitstatus is not null");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusEqualTo(String value) {
            addCriterion("ptp_profitstatus =", value, "ptpProfitstatus");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusNotEqualTo(String value) {
            addCriterion("ptp_profitstatus <>", value, "ptpProfitstatus");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusGreaterThan(String value) {
            addCriterion("ptp_profitstatus >", value, "ptpProfitstatus");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusGreaterThanOrEqualTo(String value) {
            addCriterion("ptp_profitstatus >=", value, "ptpProfitstatus");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusLessThan(String value) {
            addCriterion("ptp_profitstatus <", value, "ptpProfitstatus");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusLessThanOrEqualTo(String value) {
            addCriterion("ptp_profitstatus <=", value, "ptpProfitstatus");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusLike(String value) {
            addCriterion("ptp_profitstatus like", value, "ptpProfitstatus");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusNotLike(String value) {
            addCriterion("ptp_profitstatus not like", value, "ptpProfitstatus");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusIn(List<String> values) {
            addCriterion("ptp_profitstatus in", values, "ptpProfitstatus");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusNotIn(List<String> values) {
            addCriterion("ptp_profitstatus not in", values, "ptpProfitstatus");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusBetween(String value1, String value2) {
            addCriterion("ptp_profitstatus between", value1, value2, "ptpProfitstatus");
            return (Criteria) this;
        }

        public Criteria andPtpProfitstatusNotBetween(String value1, String value2) {
            addCriterion("ptp_profitstatus not between", value1, value2, "ptpProfitstatus");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkIsNull() {
            addCriterion("ptp_remark is null");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkIsNotNull() {
            addCriterion("ptp_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkEqualTo(String value) {
            addCriterion("ptp_remark =", value, "ptpRemark");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkNotEqualTo(String value) {
            addCriterion("ptp_remark <>", value, "ptpRemark");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkGreaterThan(String value) {
            addCriterion("ptp_remark >", value, "ptpRemark");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ptp_remark >=", value, "ptpRemark");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkLessThan(String value) {
            addCriterion("ptp_remark <", value, "ptpRemark");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkLessThanOrEqualTo(String value) {
            addCriterion("ptp_remark <=", value, "ptpRemark");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkLike(String value) {
            addCriterion("ptp_remark like", value, "ptpRemark");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkNotLike(String value) {
            addCriterion("ptp_remark not like", value, "ptpRemark");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkIn(List<String> values) {
            addCriterion("ptp_remark in", values, "ptpRemark");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkNotIn(List<String> values) {
            addCriterion("ptp_remark not in", values, "ptpRemark");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkBetween(String value1, String value2) {
            addCriterion("ptp_remark between", value1, value2, "ptpRemark");
            return (Criteria) this;
        }

        public Criteria andPtpRemarkNotBetween(String value1, String value2) {
            addCriterion("ptp_remark not between", value1, value2, "ptpRemark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}