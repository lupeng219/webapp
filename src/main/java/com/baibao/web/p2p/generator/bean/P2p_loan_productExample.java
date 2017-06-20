package com.baibao.web.p2p.generator.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_loan_productExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_loan_productExample() {
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

        public Criteria andPpProductidIsNull() {
            addCriterion("pp_productId is null");
            return (Criteria) this;
        }

        public Criteria andPpProductidIsNotNull() {
            addCriterion("pp_productId is not null");
            return (Criteria) this;
        }

        public Criteria andPpProductidEqualTo(Long value) {
            addCriterion("pp_productId =", value, "ppProductid");
            return (Criteria) this;
        }

        public Criteria andPpProductidNotEqualTo(Long value) {
            addCriterion("pp_productId <>", value, "ppProductid");
            return (Criteria) this;
        }

        public Criteria andPpProductidGreaterThan(Long value) {
            addCriterion("pp_productId >", value, "ppProductid");
            return (Criteria) this;
        }

        public Criteria andPpProductidGreaterThanOrEqualTo(Long value) {
            addCriterion("pp_productId >=", value, "ppProductid");
            return (Criteria) this;
        }

        public Criteria andPpProductidLessThan(Long value) {
            addCriterion("pp_productId <", value, "ppProductid");
            return (Criteria) this;
        }

        public Criteria andPpProductidLessThanOrEqualTo(Long value) {
            addCriterion("pp_productId <=", value, "ppProductid");
            return (Criteria) this;
        }

        public Criteria andPpProductidIn(List<Long> values) {
            addCriterion("pp_productId in", values, "ppProductid");
            return (Criteria) this;
        }

        public Criteria andPpProductidNotIn(List<Long> values) {
            addCriterion("pp_productId not in", values, "ppProductid");
            return (Criteria) this;
        }

        public Criteria andPpProductidBetween(Long value1, Long value2) {
            addCriterion("pp_productId between", value1, value2, "ppProductid");
            return (Criteria) this;
        }

        public Criteria andPpProductidNotBetween(Long value1, Long value2) {
            addCriterion("pp_productId not between", value1, value2, "ppProductid");
            return (Criteria) this;
        }

        public Criteria andPpProductnoIsNull() {
            addCriterion("pp_productNo is null");
            return (Criteria) this;
        }

        public Criteria andPpProductnoIsNotNull() {
            addCriterion("pp_productNo is not null");
            return (Criteria) this;
        }

        public Criteria andPpProductnoEqualTo(String value) {
            addCriterion("pp_productNo =", value, "ppProductno");
            return (Criteria) this;
        }

        public Criteria andPpProductnoNotEqualTo(String value) {
            addCriterion("pp_productNo <>", value, "ppProductno");
            return (Criteria) this;
        }

        public Criteria andPpProductnoGreaterThan(String value) {
            addCriterion("pp_productNo >", value, "ppProductno");
            return (Criteria) this;
        }

        public Criteria andPpProductnoGreaterThanOrEqualTo(String value) {
            addCriterion("pp_productNo >=", value, "ppProductno");
            return (Criteria) this;
        }

        public Criteria andPpProductnoLessThan(String value) {
            addCriterion("pp_productNo <", value, "ppProductno");
            return (Criteria) this;
        }

        public Criteria andPpProductnoLessThanOrEqualTo(String value) {
            addCriterion("pp_productNo <=", value, "ppProductno");
            return (Criteria) this;
        }

        public Criteria andPpProductnoLike(String value) {
            addCriterion("pp_productNo like", value, "ppProductno");
            return (Criteria) this;
        }

        public Criteria andPpProductnoNotLike(String value) {
            addCriterion("pp_productNo not like", value, "ppProductno");
            return (Criteria) this;
        }

        public Criteria andPpProductnoIn(List<String> values) {
            addCriterion("pp_productNo in", values, "ppProductno");
            return (Criteria) this;
        }

        public Criteria andPpProductnoNotIn(List<String> values) {
            addCriterion("pp_productNo not in", values, "ppProductno");
            return (Criteria) this;
        }

        public Criteria andPpProductnoBetween(String value1, String value2) {
            addCriterion("pp_productNo between", value1, value2, "ppProductno");
            return (Criteria) this;
        }

        public Criteria andPpProductnoNotBetween(String value1, String value2) {
            addCriterion("pp_productNo not between", value1, value2, "ppProductno");
            return (Criteria) this;
        }

        public Criteria andPpCustnoIsNull() {
            addCriterion("pp_custNo is null");
            return (Criteria) this;
        }

        public Criteria andPpCustnoIsNotNull() {
            addCriterion("pp_custNo is not null");
            return (Criteria) this;
        }

        public Criteria andPpCustnoEqualTo(String value) {
            addCriterion("pp_custNo =", value, "ppCustno");
            return (Criteria) this;
        }

        public Criteria andPpCustnoNotEqualTo(String value) {
            addCriterion("pp_custNo <>", value, "ppCustno");
            return (Criteria) this;
        }

        public Criteria andPpCustnoGreaterThan(String value) {
            addCriterion("pp_custNo >", value, "ppCustno");
            return (Criteria) this;
        }

        public Criteria andPpCustnoGreaterThanOrEqualTo(String value) {
            addCriterion("pp_custNo >=", value, "ppCustno");
            return (Criteria) this;
        }

        public Criteria andPpCustnoLessThan(String value) {
            addCriterion("pp_custNo <", value, "ppCustno");
            return (Criteria) this;
        }

        public Criteria andPpCustnoLessThanOrEqualTo(String value) {
            addCriterion("pp_custNo <=", value, "ppCustno");
            return (Criteria) this;
        }

        public Criteria andPpCustnoLike(String value) {
            addCriterion("pp_custNo like", value, "ppCustno");
            return (Criteria) this;
        }

        public Criteria andPpCustnoNotLike(String value) {
            addCriterion("pp_custNo not like", value, "ppCustno");
            return (Criteria) this;
        }

        public Criteria andPpCustnoIn(List<String> values) {
            addCriterion("pp_custNo in", values, "ppCustno");
            return (Criteria) this;
        }

        public Criteria andPpCustnoNotIn(List<String> values) {
            addCriterion("pp_custNo not in", values, "ppCustno");
            return (Criteria) this;
        }

        public Criteria andPpCustnoBetween(String value1, String value2) {
            addCriterion("pp_custNo between", value1, value2, "ppCustno");
            return (Criteria) this;
        }

        public Criteria andPpCustnoNotBetween(String value1, String value2) {
            addCriterion("pp_custNo not between", value1, value2, "ppCustno");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleIsNull() {
            addCriterion("pp_loanTitle is null");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleIsNotNull() {
            addCriterion("pp_loanTitle is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleEqualTo(String value) {
            addCriterion("pp_loanTitle =", value, "ppLoantitle");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleNotEqualTo(String value) {
            addCriterion("pp_loanTitle <>", value, "ppLoantitle");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleGreaterThan(String value) {
            addCriterion("pp_loanTitle >", value, "ppLoantitle");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleGreaterThanOrEqualTo(String value) {
            addCriterion("pp_loanTitle >=", value, "ppLoantitle");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleLessThan(String value) {
            addCriterion("pp_loanTitle <", value, "ppLoantitle");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleLessThanOrEqualTo(String value) {
            addCriterion("pp_loanTitle <=", value, "ppLoantitle");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleLike(String value) {
            addCriterion("pp_loanTitle like", value, "ppLoantitle");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleNotLike(String value) {
            addCriterion("pp_loanTitle not like", value, "ppLoantitle");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleIn(List<String> values) {
            addCriterion("pp_loanTitle in", values, "ppLoantitle");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleNotIn(List<String> values) {
            addCriterion("pp_loanTitle not in", values, "ppLoantitle");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleBetween(String value1, String value2) {
            addCriterion("pp_loanTitle between", value1, value2, "ppLoantitle");
            return (Criteria) this;
        }

        public Criteria andPpLoantitleNotBetween(String value1, String value2) {
            addCriterion("pp_loanTitle not between", value1, value2, "ppLoantitle");
            return (Criteria) this;
        }

        public Criteria andPpLoantermIsNull() {
            addCriterion("pp_loanTerm is null");
            return (Criteria) this;
        }

        public Criteria andPpLoantermIsNotNull() {
            addCriterion("pp_loanTerm is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoantermEqualTo(Integer value) {
            addCriterion("pp_loanTerm =", value, "ppLoanterm");
            return (Criteria) this;
        }

        public Criteria andPpLoantermNotEqualTo(Integer value) {
            addCriterion("pp_loanTerm <>", value, "ppLoanterm");
            return (Criteria) this;
        }

        public Criteria andPpLoantermGreaterThan(Integer value) {
            addCriterion("pp_loanTerm >", value, "ppLoanterm");
            return (Criteria) this;
        }

        public Criteria andPpLoantermGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_loanTerm >=", value, "ppLoanterm");
            return (Criteria) this;
        }

        public Criteria andPpLoantermLessThan(Integer value) {
            addCriterion("pp_loanTerm <", value, "ppLoanterm");
            return (Criteria) this;
        }

        public Criteria andPpLoantermLessThanOrEqualTo(Integer value) {
            addCriterion("pp_loanTerm <=", value, "ppLoanterm");
            return (Criteria) this;
        }

        public Criteria andPpLoantermIn(List<Integer> values) {
            addCriterion("pp_loanTerm in", values, "ppLoanterm");
            return (Criteria) this;
        }

        public Criteria andPpLoantermNotIn(List<Integer> values) {
            addCriterion("pp_loanTerm not in", values, "ppLoanterm");
            return (Criteria) this;
        }

        public Criteria andPpLoantermBetween(Integer value1, Integer value2) {
            addCriterion("pp_loanTerm between", value1, value2, "ppLoanterm");
            return (Criteria) this;
        }

        public Criteria andPpLoantermNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_loanTerm not between", value1, value2, "ppLoanterm");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountIsNull() {
            addCriterion("pp_loanAmount is null");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountIsNotNull() {
            addCriterion("pp_loanAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountEqualTo(BigDecimal value) {
            addCriterion("pp_loanAmount =", value, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountNotEqualTo(BigDecimal value) {
            addCriterion("pp_loanAmount <>", value, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountGreaterThan(BigDecimal value) {
            addCriterion("pp_loanAmount >", value, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_loanAmount >=", value, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountLessThan(BigDecimal value) {
            addCriterion("pp_loanAmount <", value, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_loanAmount <=", value, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountIn(List<BigDecimal> values) {
            addCriterion("pp_loanAmount in", values, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountNotIn(List<BigDecimal> values) {
            addCriterion("pp_loanAmount not in", values, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_loanAmount between", value1, value2, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_loanAmount not between", value1, value2, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountexistIsNull() {
            addCriterion("pp_loanAmountExist is null");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountexistIsNotNull() {
            addCriterion("pp_loanAmountExist is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountexistEqualTo(BigDecimal value) {
            addCriterion("pp_loanAmountExist =", value, "ppLoanamountexist");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountexistNotEqualTo(BigDecimal value) {
            addCriterion("pp_loanAmountExist <>", value, "ppLoanamountexist");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountexistGreaterThan(BigDecimal value) {
            addCriterion("pp_loanAmountExist >", value, "ppLoanamountexist");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountexistGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_loanAmountExist >=", value, "ppLoanamountexist");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountexistLessThan(BigDecimal value) {
            addCriterion("pp_loanAmountExist <", value, "ppLoanamountexist");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountexistLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_loanAmountExist <=", value, "ppLoanamountexist");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountexistIn(List<BigDecimal> values) {
            addCriterion("pp_loanAmountExist in", values, "ppLoanamountexist");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountexistNotIn(List<BigDecimal> values) {
            addCriterion("pp_loanAmountExist not in", values, "ppLoanamountexist");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountexistBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_loanAmountExist between", value1, value2, "ppLoanamountexist");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountexistNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_loanAmountExist not between", value1, value2, "ppLoanamountexist");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateIsNull() {
            addCriterion("pp_comprehensiveRate is null");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateIsNotNull() {
            addCriterion("pp_comprehensiveRate is not null");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateEqualTo(BigDecimal value) {
            addCriterion("pp_comprehensiveRate =", value, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateNotEqualTo(BigDecimal value) {
            addCriterion("pp_comprehensiveRate <>", value, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateGreaterThan(BigDecimal value) {
            addCriterion("pp_comprehensiveRate >", value, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_comprehensiveRate >=", value, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateLessThan(BigDecimal value) {
            addCriterion("pp_comprehensiveRate <", value, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_comprehensiveRate <=", value, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateIn(List<BigDecimal> values) {
            addCriterion("pp_comprehensiveRate in", values, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateNotIn(List<BigDecimal> values) {
            addCriterion("pp_comprehensiveRate not in", values, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_comprehensiveRate between", value1, value2, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_comprehensiveRate not between", value1, value2, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymentIsNull() {
            addCriterion("pp_loanRepayment is null");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymentIsNotNull() {
            addCriterion("pp_loanRepayment is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymentEqualTo(Integer value) {
            addCriterion("pp_loanRepayment =", value, "ppLoanrepayment");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymentNotEqualTo(Integer value) {
            addCriterion("pp_loanRepayment <>", value, "ppLoanrepayment");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymentGreaterThan(Integer value) {
            addCriterion("pp_loanRepayment >", value, "ppLoanrepayment");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymentGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_loanRepayment >=", value, "ppLoanrepayment");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymentLessThan(Integer value) {
            addCriterion("pp_loanRepayment <", value, "ppLoanrepayment");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymentLessThanOrEqualTo(Integer value) {
            addCriterion("pp_loanRepayment <=", value, "ppLoanrepayment");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymentIn(List<Integer> values) {
            addCriterion("pp_loanRepayment in", values, "ppLoanrepayment");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymentNotIn(List<Integer> values) {
            addCriterion("pp_loanRepayment not in", values, "ppLoanrepayment");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymentBetween(Integer value1, Integer value2) {
            addCriterion("pp_loanRepayment between", value1, value2, "ppLoanrepayment");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymentNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_loanRepayment not between", value1, value2, "ppLoanrepayment");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountIsNull() {
            addCriterion("pp_repaymentAmount is null");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountIsNotNull() {
            addCriterion("pp_repaymentAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountEqualTo(BigDecimal value) {
            addCriterion("pp_repaymentAmount =", value, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountNotEqualTo(BigDecimal value) {
            addCriterion("pp_repaymentAmount <>", value, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountGreaterThan(BigDecimal value) {
            addCriterion("pp_repaymentAmount >", value, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_repaymentAmount >=", value, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountLessThan(BigDecimal value) {
            addCriterion("pp_repaymentAmount <", value, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_repaymentAmount <=", value, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountIn(List<BigDecimal> values) {
            addCriterion("pp_repaymentAmount in", values, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountNotIn(List<BigDecimal> values) {
            addCriterion("pp_repaymentAmount not in", values, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_repaymentAmount between", value1, value2, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_repaymentAmount not between", value1, value2, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidIsNull() {
            addCriterion("pp_productTypeId is null");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidIsNotNull() {
            addCriterion("pp_productTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidEqualTo(String value) {
            addCriterion("pp_productTypeId =", value, "ppProducttypeid");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidNotEqualTo(String value) {
            addCriterion("pp_productTypeId <>", value, "ppProducttypeid");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidGreaterThan(String value) {
            addCriterion("pp_productTypeId >", value, "ppProducttypeid");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidGreaterThanOrEqualTo(String value) {
            addCriterion("pp_productTypeId >=", value, "ppProducttypeid");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidLessThan(String value) {
            addCriterion("pp_productTypeId <", value, "ppProducttypeid");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidLessThanOrEqualTo(String value) {
            addCriterion("pp_productTypeId <=", value, "ppProducttypeid");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidLike(String value) {
            addCriterion("pp_productTypeId like", value, "ppProducttypeid");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidNotLike(String value) {
            addCriterion("pp_productTypeId not like", value, "ppProducttypeid");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidIn(List<String> values) {
            addCriterion("pp_productTypeId in", values, "ppProducttypeid");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidNotIn(List<String> values) {
            addCriterion("pp_productTypeId not in", values, "ppProducttypeid");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidBetween(String value1, String value2) {
            addCriterion("pp_productTypeId between", value1, value2, "ppProducttypeid");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeidNotBetween(String value1, String value2) {
            addCriterion("pp_productTypeId not between", value1, value2, "ppProducttypeid");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidIsNull() {
            addCriterion("pp_loan_applyId is null");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidIsNotNull() {
            addCriterion("pp_loan_applyId is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidEqualTo(String value) {
            addCriterion("pp_loan_applyId =", value, "ppLoanApplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidNotEqualTo(String value) {
            addCriterion("pp_loan_applyId <>", value, "ppLoanApplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidGreaterThan(String value) {
            addCriterion("pp_loan_applyId >", value, "ppLoanApplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidGreaterThanOrEqualTo(String value) {
            addCriterion("pp_loan_applyId >=", value, "ppLoanApplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidLessThan(String value) {
            addCriterion("pp_loan_applyId <", value, "ppLoanApplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidLessThanOrEqualTo(String value) {
            addCriterion("pp_loan_applyId <=", value, "ppLoanApplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidLike(String value) {
            addCriterion("pp_loan_applyId like", value, "ppLoanApplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidNotLike(String value) {
            addCriterion("pp_loan_applyId not like", value, "ppLoanApplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidIn(List<String> values) {
            addCriterion("pp_loan_applyId in", values, "ppLoanApplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidNotIn(List<String> values) {
            addCriterion("pp_loan_applyId not in", values, "ppLoanApplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidBetween(String value1, String value2) {
            addCriterion("pp_loan_applyId between", value1, value2, "ppLoanApplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanApplyidNotBetween(String value1, String value2) {
            addCriterion("pp_loan_applyId not between", value1, value2, "ppLoanApplyid");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstatusIsNull() {
            addCriterion("pp_bulkLoanStatus is null");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstatusIsNotNull() {
            addCriterion("pp_bulkLoanStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstatusEqualTo(Integer value) {
            addCriterion("pp_bulkLoanStatus =", value, "ppBulkloanstatus");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstatusNotEqualTo(Integer value) {
            addCriterion("pp_bulkLoanStatus <>", value, "ppBulkloanstatus");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstatusGreaterThan(Integer value) {
            addCriterion("pp_bulkLoanStatus >", value, "ppBulkloanstatus");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_bulkLoanStatus >=", value, "ppBulkloanstatus");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstatusLessThan(Integer value) {
            addCriterion("pp_bulkLoanStatus <", value, "ppBulkloanstatus");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstatusLessThanOrEqualTo(Integer value) {
            addCriterion("pp_bulkLoanStatus <=", value, "ppBulkloanstatus");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstatusIn(List<Integer> values) {
            addCriterion("pp_bulkLoanStatus in", values, "ppBulkloanstatus");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstatusNotIn(List<Integer> values) {
            addCriterion("pp_bulkLoanStatus not in", values, "ppBulkloanstatus");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstatusBetween(Integer value1, Integer value2) {
            addCriterion("pp_bulkLoanStatus between", value1, value2, "ppBulkloanstatus");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_bulkLoanStatus not between", value1, value2, "ppBulkloanstatus");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstarttimeIsNull() {
            addCriterion("pp_bulkLoanStartTime is null");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstarttimeIsNotNull() {
            addCriterion("pp_bulkLoanStartTime is not null");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstarttimeEqualTo(Date value) {
            addCriterion("pp_bulkLoanStartTime =", value, "ppBulkloanstarttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstarttimeNotEqualTo(Date value) {
            addCriterion("pp_bulkLoanStartTime <>", value, "ppBulkloanstarttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstarttimeGreaterThan(Date value) {
            addCriterion("pp_bulkLoanStartTime >", value, "ppBulkloanstarttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pp_bulkLoanStartTime >=", value, "ppBulkloanstarttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstarttimeLessThan(Date value) {
            addCriterion("pp_bulkLoanStartTime <", value, "ppBulkloanstarttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstarttimeLessThanOrEqualTo(Date value) {
            addCriterion("pp_bulkLoanStartTime <=", value, "ppBulkloanstarttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstarttimeIn(List<Date> values) {
            addCriterion("pp_bulkLoanStartTime in", values, "ppBulkloanstarttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstarttimeNotIn(List<Date> values) {
            addCriterion("pp_bulkLoanStartTime not in", values, "ppBulkloanstarttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstarttimeBetween(Date value1, Date value2) {
            addCriterion("pp_bulkLoanStartTime between", value1, value2, "ppBulkloanstarttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanstarttimeNotBetween(Date value1, Date value2) {
            addCriterion("pp_bulkLoanStartTime not between", value1, value2, "ppBulkloanstarttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanendtimeIsNull() {
            addCriterion("pp_bulkLoanEndTime is null");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanendtimeIsNotNull() {
            addCriterion("pp_bulkLoanEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanendtimeEqualTo(Date value) {
            addCriterion("pp_bulkLoanEndTime =", value, "ppBulkloanendtime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanendtimeNotEqualTo(Date value) {
            addCriterion("pp_bulkLoanEndTime <>", value, "ppBulkloanendtime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanendtimeGreaterThan(Date value) {
            addCriterion("pp_bulkLoanEndTime >", value, "ppBulkloanendtime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pp_bulkLoanEndTime >=", value, "ppBulkloanendtime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanendtimeLessThan(Date value) {
            addCriterion("pp_bulkLoanEndTime <", value, "ppBulkloanendtime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanendtimeLessThanOrEqualTo(Date value) {
            addCriterion("pp_bulkLoanEndTime <=", value, "ppBulkloanendtime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanendtimeIn(List<Date> values) {
            addCriterion("pp_bulkLoanEndTime in", values, "ppBulkloanendtime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanendtimeNotIn(List<Date> values) {
            addCriterion("pp_bulkLoanEndTime not in", values, "ppBulkloanendtime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanendtimeBetween(Date value1, Date value2) {
            addCriterion("pp_bulkLoanEndTime between", value1, value2, "ppBulkloanendtime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloanendtimeNotBetween(Date value1, Date value2) {
            addCriterion("pp_bulkLoanEndTime not between", value1, value2, "ppBulkloanendtime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloaneffecttimeIsNull() {
            addCriterion("pp_bulkLoanEffectTime is null");
            return (Criteria) this;
        }

        public Criteria andPpBulkloaneffecttimeIsNotNull() {
            addCriterion("pp_bulkLoanEffectTime is not null");
            return (Criteria) this;
        }

        public Criteria andPpBulkloaneffecttimeEqualTo(Date value) {
            addCriterion("pp_bulkLoanEffectTime =", value, "ppBulkloaneffecttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloaneffecttimeNotEqualTo(Date value) {
            addCriterion("pp_bulkLoanEffectTime <>", value, "ppBulkloaneffecttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloaneffecttimeGreaterThan(Date value) {
            addCriterion("pp_bulkLoanEffectTime >", value, "ppBulkloaneffecttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloaneffecttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pp_bulkLoanEffectTime >=", value, "ppBulkloaneffecttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloaneffecttimeLessThan(Date value) {
            addCriterion("pp_bulkLoanEffectTime <", value, "ppBulkloaneffecttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloaneffecttimeLessThanOrEqualTo(Date value) {
            addCriterion("pp_bulkLoanEffectTime <=", value, "ppBulkloaneffecttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloaneffecttimeIn(List<Date> values) {
            addCriterion("pp_bulkLoanEffectTime in", values, "ppBulkloaneffecttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloaneffecttimeNotIn(List<Date> values) {
            addCriterion("pp_bulkLoanEffectTime not in", values, "ppBulkloaneffecttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloaneffecttimeBetween(Date value1, Date value2) {
            addCriterion("pp_bulkLoanEffectTime between", value1, value2, "ppBulkloaneffecttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloaneffecttimeNotBetween(Date value1, Date value2) {
            addCriterion("pp_bulkLoanEffectTime not between", value1, value2, "ppBulkloaneffecttime");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsIsNull() {
            addCriterion("pp_bulkLoanDealSeconds is null");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsIsNotNull() {
            addCriterion("pp_bulkLoanDealSeconds is not null");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsEqualTo(String value) {
            addCriterion("pp_bulkLoanDealSeconds =", value, "ppBulkloandealseconds");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsNotEqualTo(String value) {
            addCriterion("pp_bulkLoanDealSeconds <>", value, "ppBulkloandealseconds");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsGreaterThan(String value) {
            addCriterion("pp_bulkLoanDealSeconds >", value, "ppBulkloandealseconds");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsGreaterThanOrEqualTo(String value) {
            addCriterion("pp_bulkLoanDealSeconds >=", value, "ppBulkloandealseconds");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsLessThan(String value) {
            addCriterion("pp_bulkLoanDealSeconds <", value, "ppBulkloandealseconds");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsLessThanOrEqualTo(String value) {
            addCriterion("pp_bulkLoanDealSeconds <=", value, "ppBulkloandealseconds");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsLike(String value) {
            addCriterion("pp_bulkLoanDealSeconds like", value, "ppBulkloandealseconds");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsNotLike(String value) {
            addCriterion("pp_bulkLoanDealSeconds not like", value, "ppBulkloandealseconds");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsIn(List<String> values) {
            addCriterion("pp_bulkLoanDealSeconds in", values, "ppBulkloandealseconds");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsNotIn(List<String> values) {
            addCriterion("pp_bulkLoanDealSeconds not in", values, "ppBulkloandealseconds");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsBetween(String value1, String value2) {
            addCriterion("pp_bulkLoanDealSeconds between", value1, value2, "ppBulkloandealseconds");
            return (Criteria) this;
        }

        public Criteria andPpBulkloandealsecondsNotBetween(String value1, String value2) {
            addCriterion("pp_bulkLoanDealSeconds not between", value1, value2, "ppBulkloandealseconds");
            return (Criteria) this;
        }

        public Criteria andPpTerderminamountIsNull() {
            addCriterion("pp_terderMinAmount is null");
            return (Criteria) this;
        }

        public Criteria andPpTerderminamountIsNotNull() {
            addCriterion("pp_terderMinAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPpTerderminamountEqualTo(BigDecimal value) {
            addCriterion("pp_terderMinAmount =", value, "ppTerderminamount");
            return (Criteria) this;
        }

        public Criteria andPpTerderminamountNotEqualTo(BigDecimal value) {
            addCriterion("pp_terderMinAmount <>", value, "ppTerderminamount");
            return (Criteria) this;
        }

        public Criteria andPpTerderminamountGreaterThan(BigDecimal value) {
            addCriterion("pp_terderMinAmount >", value, "ppTerderminamount");
            return (Criteria) this;
        }

        public Criteria andPpTerderminamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_terderMinAmount >=", value, "ppTerderminamount");
            return (Criteria) this;
        }

        public Criteria andPpTerderminamountLessThan(BigDecimal value) {
            addCriterion("pp_terderMinAmount <", value, "ppTerderminamount");
            return (Criteria) this;
        }

        public Criteria andPpTerderminamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_terderMinAmount <=", value, "ppTerderminamount");
            return (Criteria) this;
        }

        public Criteria andPpTerderminamountIn(List<BigDecimal> values) {
            addCriterion("pp_terderMinAmount in", values, "ppTerderminamount");
            return (Criteria) this;
        }

        public Criteria andPpTerderminamountNotIn(List<BigDecimal> values) {
            addCriterion("pp_terderMinAmount not in", values, "ppTerderminamount");
            return (Criteria) this;
        }

        public Criteria andPpTerderminamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_terderMinAmount between", value1, value2, "ppTerderminamount");
            return (Criteria) this;
        }

        public Criteria andPpTerderminamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_terderMinAmount not between", value1, value2, "ppTerderminamount");
            return (Criteria) this;
        }

        public Criteria andPpTendermaxamountIsNull() {
            addCriterion("pp_tenderMaxAmount is null");
            return (Criteria) this;
        }

        public Criteria andPpTendermaxamountIsNotNull() {
            addCriterion("pp_tenderMaxAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPpTendermaxamountEqualTo(BigDecimal value) {
            addCriterion("pp_tenderMaxAmount =", value, "ppTendermaxamount");
            return (Criteria) this;
        }

        public Criteria andPpTendermaxamountNotEqualTo(BigDecimal value) {
            addCriterion("pp_tenderMaxAmount <>", value, "ppTendermaxamount");
            return (Criteria) this;
        }

        public Criteria andPpTendermaxamountGreaterThan(BigDecimal value) {
            addCriterion("pp_tenderMaxAmount >", value, "ppTendermaxamount");
            return (Criteria) this;
        }

        public Criteria andPpTendermaxamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_tenderMaxAmount >=", value, "ppTendermaxamount");
            return (Criteria) this;
        }

        public Criteria andPpTendermaxamountLessThan(BigDecimal value) {
            addCriterion("pp_tenderMaxAmount <", value, "ppTendermaxamount");
            return (Criteria) this;
        }

        public Criteria andPpTendermaxamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_tenderMaxAmount <=", value, "ppTendermaxamount");
            return (Criteria) this;
        }

        public Criteria andPpTendermaxamountIn(List<BigDecimal> values) {
            addCriterion("pp_tenderMaxAmount in", values, "ppTendermaxamount");
            return (Criteria) this;
        }

        public Criteria andPpTendermaxamountNotIn(List<BigDecimal> values) {
            addCriterion("pp_tenderMaxAmount not in", values, "ppTendermaxamount");
            return (Criteria) this;
        }

        public Criteria andPpTendermaxamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_tenderMaxAmount between", value1, value2, "ppTendermaxamount");
            return (Criteria) this;
        }

        public Criteria andPpTendermaxamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_tenderMaxAmount not between", value1, value2, "ppTendermaxamount");
            return (Criteria) this;
        }

        public Criteria andPpTenderincreaseamountIsNull() {
            addCriterion("pp_tenderIncreaseAmount is null");
            return (Criteria) this;
        }

        public Criteria andPpTenderincreaseamountIsNotNull() {
            addCriterion("pp_tenderIncreaseAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPpTenderincreaseamountEqualTo(BigDecimal value) {
            addCriterion("pp_tenderIncreaseAmount =", value, "ppTenderincreaseamount");
            return (Criteria) this;
        }

        public Criteria andPpTenderincreaseamountNotEqualTo(BigDecimal value) {
            addCriterion("pp_tenderIncreaseAmount <>", value, "ppTenderincreaseamount");
            return (Criteria) this;
        }

        public Criteria andPpTenderincreaseamountGreaterThan(BigDecimal value) {
            addCriterion("pp_tenderIncreaseAmount >", value, "ppTenderincreaseamount");
            return (Criteria) this;
        }

        public Criteria andPpTenderincreaseamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_tenderIncreaseAmount >=", value, "ppTenderincreaseamount");
            return (Criteria) this;
        }

        public Criteria andPpTenderincreaseamountLessThan(BigDecimal value) {
            addCriterion("pp_tenderIncreaseAmount <", value, "ppTenderincreaseamount");
            return (Criteria) this;
        }

        public Criteria andPpTenderincreaseamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pp_tenderIncreaseAmount <=", value, "ppTenderincreaseamount");
            return (Criteria) this;
        }

        public Criteria andPpTenderincreaseamountIn(List<BigDecimal> values) {
            addCriterion("pp_tenderIncreaseAmount in", values, "ppTenderincreaseamount");
            return (Criteria) this;
        }

        public Criteria andPpTenderincreaseamountNotIn(List<BigDecimal> values) {
            addCriterion("pp_tenderIncreaseAmount not in", values, "ppTenderincreaseamount");
            return (Criteria) this;
        }

        public Criteria andPpTenderincreaseamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_tenderIncreaseAmount between", value1, value2, "ppTenderincreaseamount");
            return (Criteria) this;
        }

        public Criteria andPpTenderincreaseamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pp_tenderIncreaseAmount not between", value1, value2, "ppTenderincreaseamount");
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