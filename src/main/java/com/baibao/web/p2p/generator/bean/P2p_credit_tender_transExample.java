package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_credit_tender_transExample implements Serializable{
    
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_credit_tender_transExample() {
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

        public Criteria andPctIdIsNull() {
            addCriterion("pct_id is null");
            return (Criteria) this;
        }

        public Criteria andPctIdIsNotNull() {
            addCriterion("pct_id is not null");
            return (Criteria) this;
        }

        public Criteria andPctIdEqualTo(Long value) {
            addCriterion("pct_id =", value, "pctId");
            return (Criteria) this;
        }

        public Criteria andPctIdNotEqualTo(Long value) {
            addCriterion("pct_id <>", value, "pctId");
            return (Criteria) this;
        }

        public Criteria andPctIdGreaterThan(Long value) {
            addCriterion("pct_id >", value, "pctId");
            return (Criteria) this;
        }

        public Criteria andPctIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pct_id >=", value, "pctId");
            return (Criteria) this;
        }

        public Criteria andPctIdLessThan(Long value) {
            addCriterion("pct_id <", value, "pctId");
            return (Criteria) this;
        }

        public Criteria andPctIdLessThanOrEqualTo(Long value) {
            addCriterion("pct_id <=", value, "pctId");
            return (Criteria) this;
        }

        public Criteria andPctIdIn(List<Long> values) {
            addCriterion("pct_id in", values, "pctId");
            return (Criteria) this;
        }

        public Criteria andPctIdNotIn(List<Long> values) {
            addCriterion("pct_id not in", values, "pctId");
            return (Criteria) this;
        }

        public Criteria andPctIdBetween(Long value1, Long value2) {
            addCriterion("pct_id between", value1, value2, "pctId");
            return (Criteria) this;
        }

        public Criteria andPctIdNotBetween(Long value1, Long value2) {
            addCriterion("pct_id not between", value1, value2, "pctId");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoIsNull() {
            addCriterion("pct_transFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoIsNotNull() {
            addCriterion("pct_transFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoEqualTo(String value) {
            addCriterion("pct_transFlowNo =", value, "pctTransflowno");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoNotEqualTo(String value) {
            addCriterion("pct_transFlowNo <>", value, "pctTransflowno");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoGreaterThan(String value) {
            addCriterion("pct_transFlowNo >", value, "pctTransflowno");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoGreaterThanOrEqualTo(String value) {
            addCriterion("pct_transFlowNo >=", value, "pctTransflowno");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoLessThan(String value) {
            addCriterion("pct_transFlowNo <", value, "pctTransflowno");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoLessThanOrEqualTo(String value) {
            addCriterion("pct_transFlowNo <=", value, "pctTransflowno");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoLike(String value) {
            addCriterion("pct_transFlowNo like", value, "pctTransflowno");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoNotLike(String value) {
            addCriterion("pct_transFlowNo not like", value, "pctTransflowno");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoIn(List<String> values) {
            addCriterion("pct_transFlowNo in", values, "pctTransflowno");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoNotIn(List<String> values) {
            addCriterion("pct_transFlowNo not in", values, "pctTransflowno");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoBetween(String value1, String value2) {
            addCriterion("pct_transFlowNo between", value1, value2, "pctTransflowno");
            return (Criteria) this;
        }

        public Criteria andPctTransflownoNotBetween(String value1, String value2) {
            addCriterion("pct_transFlowNo not between", value1, value2, "pctTransflowno");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoIsNull() {
            addCriterion("pct_outCustNo is null");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoIsNotNull() {
            addCriterion("pct_outCustNo is not null");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoEqualTo(String value) {
            addCriterion("pct_outCustNo =", value, "pctOutcustno");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoNotEqualTo(String value) {
            addCriterion("pct_outCustNo <>", value, "pctOutcustno");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoGreaterThan(String value) {
            addCriterion("pct_outCustNo >", value, "pctOutcustno");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoGreaterThanOrEqualTo(String value) {
            addCriterion("pct_outCustNo >=", value, "pctOutcustno");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoLessThan(String value) {
            addCriterion("pct_outCustNo <", value, "pctOutcustno");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoLessThanOrEqualTo(String value) {
            addCriterion("pct_outCustNo <=", value, "pctOutcustno");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoLike(String value) {
            addCriterion("pct_outCustNo like", value, "pctOutcustno");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoNotLike(String value) {
            addCriterion("pct_outCustNo not like", value, "pctOutcustno");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoIn(List<String> values) {
            addCriterion("pct_outCustNo in", values, "pctOutcustno");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoNotIn(List<String> values) {
            addCriterion("pct_outCustNo not in", values, "pctOutcustno");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoBetween(String value1, String value2) {
            addCriterion("pct_outCustNo between", value1, value2, "pctOutcustno");
            return (Criteria) this;
        }

        public Criteria andPctOutcustnoNotBetween(String value1, String value2) {
            addCriterion("pct_outCustNo not between", value1, value2, "pctOutcustno");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeIsNull() {
            addCriterion("pct_outCustType is null");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeIsNotNull() {
            addCriterion("pct_outCustType is not null");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeEqualTo(String value) {
            addCriterion("pct_outCustType =", value, "pctOutcusttype");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeNotEqualTo(String value) {
            addCriterion("pct_outCustType <>", value, "pctOutcusttype");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeGreaterThan(String value) {
            addCriterion("pct_outCustType >", value, "pctOutcusttype");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeGreaterThanOrEqualTo(String value) {
            addCriterion("pct_outCustType >=", value, "pctOutcusttype");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeLessThan(String value) {
            addCriterion("pct_outCustType <", value, "pctOutcusttype");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeLessThanOrEqualTo(String value) {
            addCriterion("pct_outCustType <=", value, "pctOutcusttype");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeLike(String value) {
            addCriterion("pct_outCustType like", value, "pctOutcusttype");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeNotLike(String value) {
            addCriterion("pct_outCustType not like", value, "pctOutcusttype");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeIn(List<String> values) {
            addCriterion("pct_outCustType in", values, "pctOutcusttype");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeNotIn(List<String> values) {
            addCriterion("pct_outCustType not in", values, "pctOutcusttype");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeBetween(String value1, String value2) {
            addCriterion("pct_outCustType between", value1, value2, "pctOutcusttype");
            return (Criteria) this;
        }

        public Criteria andPctOutcusttypeNotBetween(String value1, String value2) {
            addCriterion("pct_outCustType not between", value1, value2, "pctOutcusttype");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccIsNull() {
            addCriterion("pct_outPayAcc is null");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccIsNotNull() {
            addCriterion("pct_outPayAcc is not null");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccEqualTo(String value) {
            addCriterion("pct_outPayAcc =", value, "pctOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccNotEqualTo(String value) {
            addCriterion("pct_outPayAcc <>", value, "pctOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccGreaterThan(String value) {
            addCriterion("pct_outPayAcc >", value, "pctOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccGreaterThanOrEqualTo(String value) {
            addCriterion("pct_outPayAcc >=", value, "pctOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccLessThan(String value) {
            addCriterion("pct_outPayAcc <", value, "pctOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccLessThanOrEqualTo(String value) {
            addCriterion("pct_outPayAcc <=", value, "pctOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccLike(String value) {
            addCriterion("pct_outPayAcc like", value, "pctOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccNotLike(String value) {
            addCriterion("pct_outPayAcc not like", value, "pctOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccIn(List<String> values) {
            addCriterion("pct_outPayAcc in", values, "pctOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccNotIn(List<String> values) {
            addCriterion("pct_outPayAcc not in", values, "pctOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccBetween(String value1, String value2) {
            addCriterion("pct_outPayAcc between", value1, value2, "pctOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccNotBetween(String value1, String value2) {
            addCriterion("pct_outPayAcc not between", value1, value2, "pctOutpayacc");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccfeeIsNull() {
            addCriterion("pct_outPayAccFee is null");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccfeeIsNotNull() {
            addCriterion("pct_outPayAccFee is not null");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccfeeEqualTo(BigDecimal value) {
            addCriterion("pct_outPayAccFee =", value, "pctOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccfeeNotEqualTo(BigDecimal value) {
            addCriterion("pct_outPayAccFee <>", value, "pctOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccfeeGreaterThan(BigDecimal value) {
            addCriterion("pct_outPayAccFee >", value, "pctOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pct_outPayAccFee >=", value, "pctOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccfeeLessThan(BigDecimal value) {
            addCriterion("pct_outPayAccFee <", value, "pctOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pct_outPayAccFee <=", value, "pctOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccfeeIn(List<BigDecimal> values) {
            addCriterion("pct_outPayAccFee in", values, "pctOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccfeeNotIn(List<BigDecimal> values) {
            addCriterion("pct_outPayAccFee not in", values, "pctOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pct_outPayAccFee between", value1, value2, "pctOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctOutpayaccfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pct_outPayAccFee not between", value1, value2, "pctOutpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeIsNull() {
            addCriterion("pct_intCustType is null");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeIsNotNull() {
            addCriterion("pct_intCustType is not null");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeEqualTo(String value) {
            addCriterion("pct_intCustType =", value, "pctIntcusttype");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeNotEqualTo(String value) {
            addCriterion("pct_intCustType <>", value, "pctIntcusttype");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeGreaterThan(String value) {
            addCriterion("pct_intCustType >", value, "pctIntcusttype");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeGreaterThanOrEqualTo(String value) {
            addCriterion("pct_intCustType >=", value, "pctIntcusttype");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeLessThan(String value) {
            addCriterion("pct_intCustType <", value, "pctIntcusttype");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeLessThanOrEqualTo(String value) {
            addCriterion("pct_intCustType <=", value, "pctIntcusttype");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeLike(String value) {
            addCriterion("pct_intCustType like", value, "pctIntcusttype");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeNotLike(String value) {
            addCriterion("pct_intCustType not like", value, "pctIntcusttype");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeIn(List<String> values) {
            addCriterion("pct_intCustType in", values, "pctIntcusttype");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeNotIn(List<String> values) {
            addCriterion("pct_intCustType not in", values, "pctIntcusttype");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeBetween(String value1, String value2) {
            addCriterion("pct_intCustType between", value1, value2, "pctIntcusttype");
            return (Criteria) this;
        }

        public Criteria andPctIntcusttypeNotBetween(String value1, String value2) {
            addCriterion("pct_intCustType not between", value1, value2, "pctIntcusttype");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccIsNull() {
            addCriterion("pct_inPayAcc is null");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccIsNotNull() {
            addCriterion("pct_inPayAcc is not null");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccEqualTo(String value) {
            addCriterion("pct_inPayAcc =", value, "pctInpayacc");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccNotEqualTo(String value) {
            addCriterion("pct_inPayAcc <>", value, "pctInpayacc");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccGreaterThan(String value) {
            addCriterion("pct_inPayAcc >", value, "pctInpayacc");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccGreaterThanOrEqualTo(String value) {
            addCriterion("pct_inPayAcc >=", value, "pctInpayacc");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccLessThan(String value) {
            addCriterion("pct_inPayAcc <", value, "pctInpayacc");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccLessThanOrEqualTo(String value) {
            addCriterion("pct_inPayAcc <=", value, "pctInpayacc");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccLike(String value) {
            addCriterion("pct_inPayAcc like", value, "pctInpayacc");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccNotLike(String value) {
            addCriterion("pct_inPayAcc not like", value, "pctInpayacc");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccIn(List<String> values) {
            addCriterion("pct_inPayAcc in", values, "pctInpayacc");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccNotIn(List<String> values) {
            addCriterion("pct_inPayAcc not in", values, "pctInpayacc");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccBetween(String value1, String value2) {
            addCriterion("pct_inPayAcc between", value1, value2, "pctInpayacc");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccNotBetween(String value1, String value2) {
            addCriterion("pct_inPayAcc not between", value1, value2, "pctInpayacc");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccfeeIsNull() {
            addCriterion("pct_inpayaccfee is null");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccfeeIsNotNull() {
            addCriterion("pct_inpayaccfee is not null");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccfeeEqualTo(BigDecimal value) {
            addCriterion("pct_inpayaccfee =", value, "pctInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccfeeNotEqualTo(BigDecimal value) {
            addCriterion("pct_inpayaccfee <>", value, "pctInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccfeeGreaterThan(BigDecimal value) {
            addCriterion("pct_inpayaccfee >", value, "pctInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pct_inpayaccfee >=", value, "pctInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccfeeLessThan(BigDecimal value) {
            addCriterion("pct_inpayaccfee <", value, "pctInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pct_inpayaccfee <=", value, "pctInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccfeeIn(List<BigDecimal> values) {
            addCriterion("pct_inpayaccfee in", values, "pctInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccfeeNotIn(List<BigDecimal> values) {
            addCriterion("pct_inpayaccfee not in", values, "pctInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pct_inpayaccfee between", value1, value2, "pctInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctInpayaccfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pct_inpayaccfee not between", value1, value2, "pctInpayaccfee");
            return (Criteria) this;
        }

        public Criteria andPctTranamtIsNull() {
            addCriterion("pct_tranamt is null");
            return (Criteria) this;
        }

        public Criteria andPctTranamtIsNotNull() {
            addCriterion("pct_tranamt is not null");
            return (Criteria) this;
        }

        public Criteria andPctTranamtEqualTo(BigDecimal value) {
            addCriterion("pct_tranamt =", value, "pctTranamt");
            return (Criteria) this;
        }

        public Criteria andPctTranamtNotEqualTo(BigDecimal value) {
            addCriterion("pct_tranamt <>", value, "pctTranamt");
            return (Criteria) this;
        }

        public Criteria andPctTranamtGreaterThan(BigDecimal value) {
            addCriterion("pct_tranamt >", value, "pctTranamt");
            return (Criteria) this;
        }

        public Criteria andPctTranamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pct_tranamt >=", value, "pctTranamt");
            return (Criteria) this;
        }

        public Criteria andPctTranamtLessThan(BigDecimal value) {
            addCriterion("pct_tranamt <", value, "pctTranamt");
            return (Criteria) this;
        }

        public Criteria andPctTranamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pct_tranamt <=", value, "pctTranamt");
            return (Criteria) this;
        }

        public Criteria andPctTranamtIn(List<BigDecimal> values) {
            addCriterion("pct_tranamt in", values, "pctTranamt");
            return (Criteria) this;
        }

        public Criteria andPctTranamtNotIn(List<BigDecimal> values) {
            addCriterion("pct_tranamt not in", values, "pctTranamt");
            return (Criteria) this;
        }

        public Criteria andPctTranamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pct_tranamt between", value1, value2, "pctTranamt");
            return (Criteria) this;
        }

        public Criteria andPctTranamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pct_tranamt not between", value1, value2, "pctTranamt");
            return (Criteria) this;
        }

        public Criteria andPctTranstimeIsNull() {
            addCriterion("pct_transTime is null");
            return (Criteria) this;
        }

        public Criteria andPctTranstimeIsNotNull() {
            addCriterion("pct_transTime is not null");
            return (Criteria) this;
        }

        public Criteria andPctTranstimeEqualTo(Date value) {
            addCriterion("pct_transTime =", value, "pctTranstime");
            return (Criteria) this;
        }

        public Criteria andPctTranstimeNotEqualTo(Date value) {
            addCriterion("pct_transTime <>", value, "pctTranstime");
            return (Criteria) this;
        }

        public Criteria andPctTranstimeGreaterThan(Date value) {
            addCriterion("pct_transTime >", value, "pctTranstime");
            return (Criteria) this;
        }

        public Criteria andPctTranstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pct_transTime >=", value, "pctTranstime");
            return (Criteria) this;
        }

        public Criteria andPctTranstimeLessThan(Date value) {
            addCriterion("pct_transTime <", value, "pctTranstime");
            return (Criteria) this;
        }

        public Criteria andPctTranstimeLessThanOrEqualTo(Date value) {
            addCriterion("pct_transTime <=", value, "pctTranstime");
            return (Criteria) this;
        }

        public Criteria andPctTranstimeIn(List<Date> values) {
            addCriterion("pct_transTime in", values, "pctTranstime");
            return (Criteria) this;
        }

        public Criteria andPctTranstimeNotIn(List<Date> values) {
            addCriterion("pct_transTime not in", values, "pctTranstime");
            return (Criteria) this;
        }

        public Criteria andPctTranstimeBetween(Date value1, Date value2) {
            addCriterion("pct_transTime between", value1, value2, "pctTranstime");
            return (Criteria) this;
        }

        public Criteria andPctTranstimeNotBetween(Date value1, Date value2) {
            addCriterion("pct_transTime not between", value1, value2, "pctTranstime");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoIsNull() {
            addCriterion("pct_tenderFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoIsNotNull() {
            addCriterion("pct_tenderFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoEqualTo(String value) {
            addCriterion("pct_tenderFlowNo =", value, "pctTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoNotEqualTo(String value) {
            addCriterion("pct_tenderFlowNo <>", value, "pctTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoGreaterThan(String value) {
            addCriterion("pct_tenderFlowNo >", value, "pctTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoGreaterThanOrEqualTo(String value) {
            addCriterion("pct_tenderFlowNo >=", value, "pctTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoLessThan(String value) {
            addCriterion("pct_tenderFlowNo <", value, "pctTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoLessThanOrEqualTo(String value) {
            addCriterion("pct_tenderFlowNo <=", value, "pctTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoLike(String value) {
            addCriterion("pct_tenderFlowNo like", value, "pctTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoNotLike(String value) {
            addCriterion("pct_tenderFlowNo not like", value, "pctTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoIn(List<String> values) {
            addCriterion("pct_tenderFlowNo in", values, "pctTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoNotIn(List<String> values) {
            addCriterion("pct_tenderFlowNo not in", values, "pctTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoBetween(String value1, String value2) {
            addCriterion("pct_tenderFlowNo between", value1, value2, "pctTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPctTenderflownoNotBetween(String value1, String value2) {
            addCriterion("pct_tenderFlowNo not between", value1, value2, "pctTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseTimeIsNull() {
            addCriterion("pct_host_response_time is null");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseTimeIsNotNull() {
            addCriterion("pct_host_response_time is not null");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseTimeEqualTo(Date value) {
            addCriterion("pct_host_response_time =", value, "pctHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseTimeNotEqualTo(Date value) {
            addCriterion("pct_host_response_time <>", value, "pctHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseTimeGreaterThan(Date value) {
            addCriterion("pct_host_response_time >", value, "pctHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pct_host_response_time >=", value, "pctHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseTimeLessThan(Date value) {
            addCriterion("pct_host_response_time <", value, "pctHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseTimeLessThanOrEqualTo(Date value) {
            addCriterion("pct_host_response_time <=", value, "pctHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseTimeIn(List<Date> values) {
            addCriterion("pct_host_response_time in", values, "pctHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseTimeNotIn(List<Date> values) {
            addCriterion("pct_host_response_time not in", values, "pctHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseTimeBetween(Date value1, Date value2) {
            addCriterion("pct_host_response_time between", value1, value2, "pctHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseTimeNotBetween(Date value1, Date value2) {
            addCriterion("pct_host_response_time not between", value1, value2, "pctHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumIsNull() {
            addCriterion("pct_host_response_flowNum is null");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumIsNotNull() {
            addCriterion("pct_host_response_flowNum is not null");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumEqualTo(String value) {
            addCriterion("pct_host_response_flowNum =", value, "pctHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumNotEqualTo(String value) {
            addCriterion("pct_host_response_flowNum <>", value, "pctHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumGreaterThan(String value) {
            addCriterion("pct_host_response_flowNum >", value, "pctHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumGreaterThanOrEqualTo(String value) {
            addCriterion("pct_host_response_flowNum >=", value, "pctHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumLessThan(String value) {
            addCriterion("pct_host_response_flowNum <", value, "pctHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumLessThanOrEqualTo(String value) {
            addCriterion("pct_host_response_flowNum <=", value, "pctHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumLike(String value) {
            addCriterion("pct_host_response_flowNum like", value, "pctHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumNotLike(String value) {
            addCriterion("pct_host_response_flowNum not like", value, "pctHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumIn(List<String> values) {
            addCriterion("pct_host_response_flowNum in", values, "pctHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumNotIn(List<String> values) {
            addCriterion("pct_host_response_flowNum not in", values, "pctHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumBetween(String value1, String value2) {
            addCriterion("pct_host_response_flowNum between", value1, value2, "pctHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownumNotBetween(String value1, String value2) {
            addCriterion("pct_host_response_flowNum not between", value1, value2, "pctHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeIsNull() {
            addCriterion("pct_host_return_code is null");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeIsNotNull() {
            addCriterion("pct_host_return_code is not null");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeEqualTo(String value) {
            addCriterion("pct_host_return_code =", value, "pctHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeNotEqualTo(String value) {
            addCriterion("pct_host_return_code <>", value, "pctHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeGreaterThan(String value) {
            addCriterion("pct_host_return_code >", value, "pctHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pct_host_return_code >=", value, "pctHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeLessThan(String value) {
            addCriterion("pct_host_return_code <", value, "pctHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeLessThanOrEqualTo(String value) {
            addCriterion("pct_host_return_code <=", value, "pctHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeLike(String value) {
            addCriterion("pct_host_return_code like", value, "pctHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeNotLike(String value) {
            addCriterion("pct_host_return_code not like", value, "pctHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeIn(List<String> values) {
            addCriterion("pct_host_return_code in", values, "pctHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeNotIn(List<String> values) {
            addCriterion("pct_host_return_code not in", values, "pctHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeBetween(String value1, String value2) {
            addCriterion("pct_host_return_code between", value1, value2, "pctHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnCodeNotBetween(String value1, String value2) {
            addCriterion("pct_host_return_code not between", value1, value2, "pctHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageIsNull() {
            addCriterion("pct_host_return_message is null");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageIsNotNull() {
            addCriterion("pct_host_return_message is not null");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageEqualTo(String value) {
            addCriterion("pct_host_return_message =", value, "pctHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageNotEqualTo(String value) {
            addCriterion("pct_host_return_message <>", value, "pctHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageGreaterThan(String value) {
            addCriterion("pct_host_return_message >", value, "pctHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageGreaterThanOrEqualTo(String value) {
            addCriterion("pct_host_return_message >=", value, "pctHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageLessThan(String value) {
            addCriterion("pct_host_return_message <", value, "pctHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageLessThanOrEqualTo(String value) {
            addCriterion("pct_host_return_message <=", value, "pctHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageLike(String value) {
            addCriterion("pct_host_return_message like", value, "pctHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageNotLike(String value) {
            addCriterion("pct_host_return_message not like", value, "pctHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageIn(List<String> values) {
            addCriterion("pct_host_return_message in", values, "pctHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageNotIn(List<String> values) {
            addCriterion("pct_host_return_message not in", values, "pctHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageBetween(String value1, String value2) {
            addCriterion("pct_host_return_message between", value1, value2, "pctHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPctHostReturnMessageNotBetween(String value1, String value2) {
            addCriterion("pct_host_return_message not between", value1, value2, "pctHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusIsNull() {
            addCriterion("pct_payStatus is null");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusIsNotNull() {
            addCriterion("pct_payStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusEqualTo(String value) {
            addCriterion("pct_payStatus =", value, "pctPaystatus");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusNotEqualTo(String value) {
            addCriterion("pct_payStatus <>", value, "pctPaystatus");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusGreaterThan(String value) {
            addCriterion("pct_payStatus >", value, "pctPaystatus");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusGreaterThanOrEqualTo(String value) {
            addCriterion("pct_payStatus >=", value, "pctPaystatus");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusLessThan(String value) {
            addCriterion("pct_payStatus <", value, "pctPaystatus");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusLessThanOrEqualTo(String value) {
            addCriterion("pct_payStatus <=", value, "pctPaystatus");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusLike(String value) {
            addCriterion("pct_payStatus like", value, "pctPaystatus");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusNotLike(String value) {
            addCriterion("pct_payStatus not like", value, "pctPaystatus");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusIn(List<String> values) {
            addCriterion("pct_payStatus in", values, "pctPaystatus");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusNotIn(List<String> values) {
            addCriterion("pct_payStatus not in", values, "pctPaystatus");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusBetween(String value1, String value2) {
            addCriterion("pct_payStatus between", value1, value2, "pctPaystatus");
            return (Criteria) this;
        }

        public Criteria andPctPaystatusNotBetween(String value1, String value2) {
            addCriterion("pct_payStatus not between", value1, value2, "pctPaystatus");
            return (Criteria) this;
        }

        public Criteria andPctRemarkIsNull() {
            addCriterion("pct_remark is null");
            return (Criteria) this;
        }

        public Criteria andPctRemarkIsNotNull() {
            addCriterion("pct_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPctRemarkEqualTo(String value) {
            addCriterion("pct_remark =", value, "pctRemark");
            return (Criteria) this;
        }

        public Criteria andPctRemarkNotEqualTo(String value) {
            addCriterion("pct_remark <>", value, "pctRemark");
            return (Criteria) this;
        }

        public Criteria andPctRemarkGreaterThan(String value) {
            addCriterion("pct_remark >", value, "pctRemark");
            return (Criteria) this;
        }

        public Criteria andPctRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("pct_remark >=", value, "pctRemark");
            return (Criteria) this;
        }

        public Criteria andPctRemarkLessThan(String value) {
            addCriterion("pct_remark <", value, "pctRemark");
            return (Criteria) this;
        }

        public Criteria andPctRemarkLessThanOrEqualTo(String value) {
            addCriterion("pct_remark <=", value, "pctRemark");
            return (Criteria) this;
        }

        public Criteria andPctRemarkLike(String value) {
            addCriterion("pct_remark like", value, "pctRemark");
            return (Criteria) this;
        }

        public Criteria andPctRemarkNotLike(String value) {
            addCriterion("pct_remark not like", value, "pctRemark");
            return (Criteria) this;
        }

        public Criteria andPctRemarkIn(List<String> values) {
            addCriterion("pct_remark in", values, "pctRemark");
            return (Criteria) this;
        }

        public Criteria andPctRemarkNotIn(List<String> values) {
            addCriterion("pct_remark not in", values, "pctRemark");
            return (Criteria) this;
        }

        public Criteria andPctRemarkBetween(String value1, String value2) {
            addCriterion("pct_remark between", value1, value2, "pctRemark");
            return (Criteria) this;
        }

        public Criteria andPctRemarkNotBetween(String value1, String value2) {
            addCriterion("pct_remark not between", value1, value2, "pctRemark");
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