package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_credit_tenderExample implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_credit_tenderExample() {
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

        public Criteria andPctCreditflownoIsNull() {
            addCriterion("pct_creditFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoIsNotNull() {
            addCriterion("pct_creditFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoEqualTo(String value) {
            addCriterion("pct_creditFlowNo =", value, "pctCreditflowno");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoNotEqualTo(String value) {
            addCriterion("pct_creditFlowNo <>", value, "pctCreditflowno");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoGreaterThan(String value) {
            addCriterion("pct_creditFlowNo >", value, "pctCreditflowno");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoGreaterThanOrEqualTo(String value) {
            addCriterion("pct_creditFlowNo >=", value, "pctCreditflowno");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoLessThan(String value) {
            addCriterion("pct_creditFlowNo <", value, "pctCreditflowno");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoLessThanOrEqualTo(String value) {
            addCriterion("pct_creditFlowNo <=", value, "pctCreditflowno");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoLike(String value) {
            addCriterion("pct_creditFlowNo like", value, "pctCreditflowno");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoNotLike(String value) {
            addCriterion("pct_creditFlowNo not like", value, "pctCreditflowno");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoIn(List<String> values) {
            addCriterion("pct_creditFlowNo in", values, "pctCreditflowno");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoNotIn(List<String> values) {
            addCriterion("pct_creditFlowNo not in", values, "pctCreditflowno");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoBetween(String value1, String value2) {
            addCriterion("pct_creditFlowNo between", value1, value2, "pctCreditflowno");
            return (Criteria) this;
        }

        public Criteria andPctCreditflownoNotBetween(String value1, String value2) {
            addCriterion("pct_creditFlowNo not between", value1, value2, "pctCreditflowno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoIsNull() {
            addCriterion("pct_buyCreditCustNo is null");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoIsNotNull() {
            addCriterion("pct_buyCreditCustNo is not null");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoEqualTo(String value) {
            addCriterion("pct_buyCreditCustNo =", value, "pctBuycreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoNotEqualTo(String value) {
            addCriterion("pct_buyCreditCustNo <>", value, "pctBuycreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoGreaterThan(String value) {
            addCriterion("pct_buyCreditCustNo >", value, "pctBuycreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoGreaterThanOrEqualTo(String value) {
            addCriterion("pct_buyCreditCustNo >=", value, "pctBuycreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoLessThan(String value) {
            addCriterion("pct_buyCreditCustNo <", value, "pctBuycreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoLessThanOrEqualTo(String value) {
            addCriterion("pct_buyCreditCustNo <=", value, "pctBuycreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoLike(String value) {
            addCriterion("pct_buyCreditCustNo like", value, "pctBuycreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoNotLike(String value) {
            addCriterion("pct_buyCreditCustNo not like", value, "pctBuycreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoIn(List<String> values) {
            addCriterion("pct_buyCreditCustNo in", values, "pctBuycreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoNotIn(List<String> values) {
            addCriterion("pct_buyCreditCustNo not in", values, "pctBuycreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoBetween(String value1, String value2) {
            addCriterion("pct_buyCreditCustNo between", value1, value2, "pctBuycreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditcustnoNotBetween(String value1, String value2) {
            addCriterion("pct_buyCreditCustNo not between", value1, value2, "pctBuycreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountIsNull() {
            addCriterion("pct_buyCreditAccount is null");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountIsNotNull() {
            addCriterion("pct_buyCreditAccount is not null");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountEqualTo(String value) {
            addCriterion("pct_buyCreditAccount =", value, "pctBuycreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountNotEqualTo(String value) {
            addCriterion("pct_buyCreditAccount <>", value, "pctBuycreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountGreaterThan(String value) {
            addCriterion("pct_buyCreditAccount >", value, "pctBuycreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountGreaterThanOrEqualTo(String value) {
            addCriterion("pct_buyCreditAccount >=", value, "pctBuycreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountLessThan(String value) {
            addCriterion("pct_buyCreditAccount <", value, "pctBuycreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountLessThanOrEqualTo(String value) {
            addCriterion("pct_buyCreditAccount <=", value, "pctBuycreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountLike(String value) {
            addCriterion("pct_buyCreditAccount like", value, "pctBuycreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountNotLike(String value) {
            addCriterion("pct_buyCreditAccount not like", value, "pctBuycreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountIn(List<String> values) {
            addCriterion("pct_buyCreditAccount in", values, "pctBuycreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountNotIn(List<String> values) {
            addCriterion("pct_buyCreditAccount not in", values, "pctBuycreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountBetween(String value1, String value2) {
            addCriterion("pct_buyCreditAccount between", value1, value2, "pctBuycreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctBuycreditaccountNotBetween(String value1, String value2) {
            addCriterion("pct_buyCreditAccount not between", value1, value2, "pctBuycreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctBuyamountIsNull() {
            addCriterion("pct_buyAmount is null");
            return (Criteria) this;
        }

        public Criteria andPctBuyamountIsNotNull() {
            addCriterion("pct_buyAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPctBuyamountEqualTo(BigDecimal value) {
            addCriterion("pct_buyAmount =", value, "pctBuyamount");
            return (Criteria) this;
        }

        public Criteria andPctBuyamountNotEqualTo(BigDecimal value) {
            addCriterion("pct_buyAmount <>", value, "pctBuyamount");
            return (Criteria) this;
        }

        public Criteria andPctBuyamountGreaterThan(BigDecimal value) {
            addCriterion("pct_buyAmount >", value, "pctBuyamount");
            return (Criteria) this;
        }

        public Criteria andPctBuyamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pct_buyAmount >=", value, "pctBuyamount");
            return (Criteria) this;
        }

        public Criteria andPctBuyamountLessThan(BigDecimal value) {
            addCriterion("pct_buyAmount <", value, "pctBuyamount");
            return (Criteria) this;
        }

        public Criteria andPctBuyamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pct_buyAmount <=", value, "pctBuyamount");
            return (Criteria) this;
        }

        public Criteria andPctBuyamountIn(List<BigDecimal> values) {
            addCriterion("pct_buyAmount in", values, "pctBuyamount");
            return (Criteria) this;
        }

        public Criteria andPctBuyamountNotIn(List<BigDecimal> values) {
            addCriterion("pct_buyAmount not in", values, "pctBuyamount");
            return (Criteria) this;
        }

        public Criteria andPctBuyamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pct_buyAmount between", value1, value2, "pctBuyamount");
            return (Criteria) this;
        }

        public Criteria andPctBuyamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pct_buyAmount not between", value1, value2, "pctBuyamount");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeIsNull() {
            addCriterion("pct_buyCustType is null");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeIsNotNull() {
            addCriterion("pct_buyCustType is not null");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeEqualTo(String value) {
            addCriterion("pct_buyCustType =", value, "pctBuycusttype");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeNotEqualTo(String value) {
            addCriterion("pct_buyCustType <>", value, "pctBuycusttype");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeGreaterThan(String value) {
            addCriterion("pct_buyCustType >", value, "pctBuycusttype");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeGreaterThanOrEqualTo(String value) {
            addCriterion("pct_buyCustType >=", value, "pctBuycusttype");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeLessThan(String value) {
            addCriterion("pct_buyCustType <", value, "pctBuycusttype");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeLessThanOrEqualTo(String value) {
            addCriterion("pct_buyCustType <=", value, "pctBuycusttype");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeLike(String value) {
            addCriterion("pct_buyCustType like", value, "pctBuycusttype");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeNotLike(String value) {
            addCriterion("pct_buyCustType not like", value, "pctBuycusttype");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeIn(List<String> values) {
            addCriterion("pct_buyCustType in", values, "pctBuycusttype");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeNotIn(List<String> values) {
            addCriterion("pct_buyCustType not in", values, "pctBuycusttype");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeBetween(String value1, String value2) {
            addCriterion("pct_buyCustType between", value1, value2, "pctBuycusttype");
            return (Criteria) this;
        }

        public Criteria andPctBuycusttypeNotBetween(String value1, String value2) {
            addCriterion("pct_buyCustType not between", value1, value2, "pctBuycusttype");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoIsNull() {
            addCriterion("pct_loanCreditCustNo is null");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoIsNotNull() {
            addCriterion("pct_loanCreditCustNo is not null");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoEqualTo(String value) {
            addCriterion("pct_loanCreditCustNo =", value, "pctLoancreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoNotEqualTo(String value) {
            addCriterion("pct_loanCreditCustNo <>", value, "pctLoancreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoGreaterThan(String value) {
            addCriterion("pct_loanCreditCustNo >", value, "pctLoancreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoGreaterThanOrEqualTo(String value) {
            addCriterion("pct_loanCreditCustNo >=", value, "pctLoancreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoLessThan(String value) {
            addCriterion("pct_loanCreditCustNo <", value, "pctLoancreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoLessThanOrEqualTo(String value) {
            addCriterion("pct_loanCreditCustNo <=", value, "pctLoancreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoLike(String value) {
            addCriterion("pct_loanCreditCustNo like", value, "pctLoancreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoNotLike(String value) {
            addCriterion("pct_loanCreditCustNo not like", value, "pctLoancreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoIn(List<String> values) {
            addCriterion("pct_loanCreditCustNo in", values, "pctLoancreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoNotIn(List<String> values) {
            addCriterion("pct_loanCreditCustNo not in", values, "pctLoancreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoBetween(String value1, String value2) {
            addCriterion("pct_loanCreditCustNo between", value1, value2, "pctLoancreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditcustnoNotBetween(String value1, String value2) {
            addCriterion("pct_loanCreditCustNo not between", value1, value2, "pctLoancreditcustno");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountIsNull() {
            addCriterion("pct_loanCreditAccount is null");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountIsNotNull() {
            addCriterion("pct_loanCreditAccount is not null");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountEqualTo(String value) {
            addCriterion("pct_loanCreditAccount =", value, "pctLoancreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountNotEqualTo(String value) {
            addCriterion("pct_loanCreditAccount <>", value, "pctLoancreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountGreaterThan(String value) {
            addCriterion("pct_loanCreditAccount >", value, "pctLoancreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountGreaterThanOrEqualTo(String value) {
            addCriterion("pct_loanCreditAccount >=", value, "pctLoancreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountLessThan(String value) {
            addCriterion("pct_loanCreditAccount <", value, "pctLoancreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountLessThanOrEqualTo(String value) {
            addCriterion("pct_loanCreditAccount <=", value, "pctLoancreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountLike(String value) {
            addCriterion("pct_loanCreditAccount like", value, "pctLoancreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountNotLike(String value) {
            addCriterion("pct_loanCreditAccount not like", value, "pctLoancreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountIn(List<String> values) {
            addCriterion("pct_loanCreditAccount in", values, "pctLoancreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountNotIn(List<String> values) {
            addCriterion("pct_loanCreditAccount not in", values, "pctLoancreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountBetween(String value1, String value2) {
            addCriterion("pct_loanCreditAccount between", value1, value2, "pctLoancreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctLoancreditaccountNotBetween(String value1, String value2) {
            addCriterion("pct_loanCreditAccount not between", value1, value2, "pctLoancreditaccount");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeIsNull() {
            addCriterion("pct_loanCustType is null");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeIsNotNull() {
            addCriterion("pct_loanCustType is not null");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeEqualTo(String value) {
            addCriterion("pct_loanCustType =", value, "pctLoancusttype");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeNotEqualTo(String value) {
            addCriterion("pct_loanCustType <>", value, "pctLoancusttype");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeGreaterThan(String value) {
            addCriterion("pct_loanCustType >", value, "pctLoancusttype");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeGreaterThanOrEqualTo(String value) {
            addCriterion("pct_loanCustType >=", value, "pctLoancusttype");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeLessThan(String value) {
            addCriterion("pct_loanCustType <", value, "pctLoancusttype");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeLessThanOrEqualTo(String value) {
            addCriterion("pct_loanCustType <=", value, "pctLoancusttype");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeLike(String value) {
            addCriterion("pct_loanCustType like", value, "pctLoancusttype");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeNotLike(String value) {
            addCriterion("pct_loanCustType not like", value, "pctLoancusttype");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeIn(List<String> values) {
            addCriterion("pct_loanCustType in", values, "pctLoancusttype");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeNotIn(List<String> values) {
            addCriterion("pct_loanCustType not in", values, "pctLoancusttype");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeBetween(String value1, String value2) {
            addCriterion("pct_loanCustType between", value1, value2, "pctLoancusttype");
            return (Criteria) this;
        }

        public Criteria andPctLoancusttypeNotBetween(String value1, String value2) {
            addCriterion("pct_loanCustType not between", value1, value2, "pctLoancusttype");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoIsNull() {
            addCriterion("pct_crediteFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoIsNotNull() {
            addCriterion("pct_crediteFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoEqualTo(String value) {
            addCriterion("pct_crediteFlowNo =", value, "pctCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoNotEqualTo(String value) {
            addCriterion("pct_crediteFlowNo <>", value, "pctCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoGreaterThan(String value) {
            addCriterion("pct_crediteFlowNo >", value, "pctCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoGreaterThanOrEqualTo(String value) {
            addCriterion("pct_crediteFlowNo >=", value, "pctCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoLessThan(String value) {
            addCriterion("pct_crediteFlowNo <", value, "pctCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoLessThanOrEqualTo(String value) {
            addCriterion("pct_crediteFlowNo <=", value, "pctCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoLike(String value) {
            addCriterion("pct_crediteFlowNo like", value, "pctCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoNotLike(String value) {
            addCriterion("pct_crediteFlowNo not like", value, "pctCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoIn(List<String> values) {
            addCriterion("pct_crediteFlowNo in", values, "pctCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoNotIn(List<String> values) {
            addCriterion("pct_crediteFlowNo not in", values, "pctCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoBetween(String value1, String value2) {
            addCriterion("pct_crediteFlowNo between", value1, value2, "pctCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPctCrediteflownoNotBetween(String value1, String value2) {
            addCriterion("pct_crediteFlowNo not between", value1, value2, "pctCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPctChannelIsNull() {
            addCriterion("pct_channel is null");
            return (Criteria) this;
        }

        public Criteria andPctChannelIsNotNull() {
            addCriterion("pct_channel is not null");
            return (Criteria) this;
        }

        public Criteria andPctChannelEqualTo(String value) {
            addCriterion("pct_channel =", value, "pctChannel");
            return (Criteria) this;
        }

        public Criteria andPctChannelNotEqualTo(String value) {
            addCriterion("pct_channel <>", value, "pctChannel");
            return (Criteria) this;
        }

        public Criteria andPctChannelGreaterThan(String value) {
            addCriterion("pct_channel >", value, "pctChannel");
            return (Criteria) this;
        }

        public Criteria andPctChannelGreaterThanOrEqualTo(String value) {
            addCriterion("pct_channel >=", value, "pctChannel");
            return (Criteria) this;
        }

        public Criteria andPctChannelLessThan(String value) {
            addCriterion("pct_channel <", value, "pctChannel");
            return (Criteria) this;
        }

        public Criteria andPctChannelLessThanOrEqualTo(String value) {
            addCriterion("pct_channel <=", value, "pctChannel");
            return (Criteria) this;
        }

        public Criteria andPctChannelLike(String value) {
            addCriterion("pct_channel like", value, "pctChannel");
            return (Criteria) this;
        }

        public Criteria andPctChannelNotLike(String value) {
            addCriterion("pct_channel not like", value, "pctChannel");
            return (Criteria) this;
        }

        public Criteria andPctChannelIn(List<String> values) {
            addCriterion("pct_channel in", values, "pctChannel");
            return (Criteria) this;
        }

        public Criteria andPctChannelNotIn(List<String> values) {
            addCriterion("pct_channel not in", values, "pctChannel");
            return (Criteria) this;
        }

        public Criteria andPctChannelBetween(String value1, String value2) {
            addCriterion("pct_channel between", value1, value2, "pctChannel");
            return (Criteria) this;
        }

        public Criteria andPctChannelNotBetween(String value1, String value2) {
            addCriterion("pct_channel not between", value1, value2, "pctChannel");
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

        public Criteria andPctTradestatusIsNull() {
            addCriterion("pct_tradeStatus is null");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusIsNotNull() {
            addCriterion("pct_tradeStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusEqualTo(String value) {
            addCriterion("pct_tradeStatus =", value, "pctTradestatus");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusNotEqualTo(String value) {
            addCriterion("pct_tradeStatus <>", value, "pctTradestatus");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusGreaterThan(String value) {
            addCriterion("pct_tradeStatus >", value, "pctTradestatus");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusGreaterThanOrEqualTo(String value) {
            addCriterion("pct_tradeStatus >=", value, "pctTradestatus");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusLessThan(String value) {
            addCriterion("pct_tradeStatus <", value, "pctTradestatus");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusLessThanOrEqualTo(String value) {
            addCriterion("pct_tradeStatus <=", value, "pctTradestatus");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusLike(String value) {
            addCriterion("pct_tradeStatus like", value, "pctTradestatus");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusNotLike(String value) {
            addCriterion("pct_tradeStatus not like", value, "pctTradestatus");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusIn(List<String> values) {
            addCriterion("pct_tradeStatus in", values, "pctTradestatus");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusNotIn(List<String> values) {
            addCriterion("pct_tradeStatus not in", values, "pctTradestatus");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusBetween(String value1, String value2) {
            addCriterion("pct_tradeStatus between", value1, value2, "pctTradestatus");
            return (Criteria) this;
        }

        public Criteria andPctTradestatusNotBetween(String value1, String value2) {
            addCriterion("pct_tradeStatus not between", value1, value2, "pctTradestatus");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeIsNull() {
            addCriterion("pct_payStatusCode is null");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeIsNotNull() {
            addCriterion("pct_payStatusCode is not null");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeEqualTo(String value) {
            addCriterion("pct_payStatusCode =", value, "pctPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeNotEqualTo(String value) {
            addCriterion("pct_payStatusCode <>", value, "pctPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeGreaterThan(String value) {
            addCriterion("pct_payStatusCode >", value, "pctPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeGreaterThanOrEqualTo(String value) {
            addCriterion("pct_payStatusCode >=", value, "pctPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeLessThan(String value) {
            addCriterion("pct_payStatusCode <", value, "pctPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeLessThanOrEqualTo(String value) {
            addCriterion("pct_payStatusCode <=", value, "pctPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeLike(String value) {
            addCriterion("pct_payStatusCode like", value, "pctPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeNotLike(String value) {
            addCriterion("pct_payStatusCode not like", value, "pctPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeIn(List<String> values) {
            addCriterion("pct_payStatusCode in", values, "pctPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeNotIn(List<String> values) {
            addCriterion("pct_payStatusCode not in", values, "pctPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeBetween(String value1, String value2) {
            addCriterion("pct_payStatusCode between", value1, value2, "pctPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPctPaystatuscodeNotBetween(String value1, String value2) {
            addCriterion("pct_payStatusCode not between", value1, value2, "pctPaystatuscode");
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

        public Criteria andPctHostResponseFlownoIsNull() {
            addCriterion("pct_host_response_flowNo is null");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoIsNotNull() {
            addCriterion("pct_host_response_flowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoEqualTo(String value) {
            addCriterion("pct_host_response_flowNo =", value, "pctHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoNotEqualTo(String value) {
            addCriterion("pct_host_response_flowNo <>", value, "pctHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoGreaterThan(String value) {
            addCriterion("pct_host_response_flowNo >", value, "pctHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoGreaterThanOrEqualTo(String value) {
            addCriterion("pct_host_response_flowNo >=", value, "pctHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoLessThan(String value) {
            addCriterion("pct_host_response_flowNo <", value, "pctHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoLessThanOrEqualTo(String value) {
            addCriterion("pct_host_response_flowNo <=", value, "pctHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoLike(String value) {
            addCriterion("pct_host_response_flowNo like", value, "pctHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoNotLike(String value) {
            addCriterion("pct_host_response_flowNo not like", value, "pctHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoIn(List<String> values) {
            addCriterion("pct_host_response_flowNo in", values, "pctHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoNotIn(List<String> values) {
            addCriterion("pct_host_response_flowNo not in", values, "pctHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoBetween(String value1, String value2) {
            addCriterion("pct_host_response_flowNo between", value1, value2, "pctHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPctHostResponseFlownoNotBetween(String value1, String value2) {
            addCriterion("pct_host_response_flowNo not between", value1, value2, "pctHostResponseFlowno");
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

        public Criteria andPctDealstatusIsNull() {
            addCriterion("pct_dealStatus is null");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusIsNotNull() {
            addCriterion("pct_dealStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusEqualTo(String value) {
            addCriterion("pct_dealStatus =", value, "pctDealstatus");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusNotEqualTo(String value) {
            addCriterion("pct_dealStatus <>", value, "pctDealstatus");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusGreaterThan(String value) {
            addCriterion("pct_dealStatus >", value, "pctDealstatus");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusGreaterThanOrEqualTo(String value) {
            addCriterion("pct_dealStatus >=", value, "pctDealstatus");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusLessThan(String value) {
            addCriterion("pct_dealStatus <", value, "pctDealstatus");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusLessThanOrEqualTo(String value) {
            addCriterion("pct_dealStatus <=", value, "pctDealstatus");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusLike(String value) {
            addCriterion("pct_dealStatus like", value, "pctDealstatus");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusNotLike(String value) {
            addCriterion("pct_dealStatus not like", value, "pctDealstatus");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusIn(List<String> values) {
            addCriterion("pct_dealStatus in", values, "pctDealstatus");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusNotIn(List<String> values) {
            addCriterion("pct_dealStatus not in", values, "pctDealstatus");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusBetween(String value1, String value2) {
            addCriterion("pct_dealStatus between", value1, value2, "pctDealstatus");
            return (Criteria) this;
        }

        public Criteria andPctDealstatusNotBetween(String value1, String value2) {
            addCriterion("pct_dealStatus not between", value1, value2, "pctDealstatus");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusIsNull() {
            addCriterion("pct_backStatus is null");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusIsNotNull() {
            addCriterion("pct_backStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusEqualTo(String value) {
            addCriterion("pct_backStatus =", value, "pctBackstatus");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusNotEqualTo(String value) {
            addCriterion("pct_backStatus <>", value, "pctBackstatus");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusGreaterThan(String value) {
            addCriterion("pct_backStatus >", value, "pctBackstatus");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusGreaterThanOrEqualTo(String value) {
            addCriterion("pct_backStatus >=", value, "pctBackstatus");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusLessThan(String value) {
            addCriterion("pct_backStatus <", value, "pctBackstatus");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusLessThanOrEqualTo(String value) {
            addCriterion("pct_backStatus <=", value, "pctBackstatus");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusLike(String value) {
            addCriterion("pct_backStatus like", value, "pctBackstatus");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusNotLike(String value) {
            addCriterion("pct_backStatus not like", value, "pctBackstatus");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusIn(List<String> values) {
            addCriterion("pct_backStatus in", values, "pctBackstatus");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusNotIn(List<String> values) {
            addCriterion("pct_backStatus not in", values, "pctBackstatus");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusBetween(String value1, String value2) {
            addCriterion("pct_backStatus between", value1, value2, "pctBackstatus");
            return (Criteria) this;
        }

        public Criteria andPctBackstatusNotBetween(String value1, String value2) {
            addCriterion("pct_backStatus not between", value1, value2, "pctBackstatus");
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