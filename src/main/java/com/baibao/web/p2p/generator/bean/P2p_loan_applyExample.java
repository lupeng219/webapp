package com.baibao.web.p2p.generator.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_loan_applyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_loan_applyExample() {
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

        public Criteria andPpLoanapplyidIsNull() {
            addCriterion("pp_loanApplyID is null");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplyidIsNotNull() {
            addCriterion("pp_loanApplyID is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplyidEqualTo(Integer value) {
            addCriterion("pp_loanApplyID =", value, "ppLoanapplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplyidNotEqualTo(Integer value) {
            addCriterion("pp_loanApplyID <>", value, "ppLoanapplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplyidGreaterThan(Integer value) {
            addCriterion("pp_loanApplyID >", value, "ppLoanapplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_loanApplyID >=", value, "ppLoanapplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplyidLessThan(Integer value) {
            addCriterion("pp_loanApplyID <", value, "ppLoanapplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplyidLessThanOrEqualTo(Integer value) {
            addCriterion("pp_loanApplyID <=", value, "ppLoanapplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplyidIn(List<Integer> values) {
            addCriterion("pp_loanApplyID in", values, "ppLoanapplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplyidNotIn(List<Integer> values) {
            addCriterion("pp_loanApplyID not in", values, "ppLoanapplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplyidBetween(Integer value1, Integer value2) {
            addCriterion("pp_loanApplyID between", value1, value2, "ppLoanapplyid");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplyidNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_loanApplyID not between", value1, value2, "ppLoanapplyid");
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

        public Criteria andPpProducttypeIsNull() {
            addCriterion("pp_productType is null");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeIsNotNull() {
            addCriterion("pp_productType is not null");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeEqualTo(String value) {
            addCriterion("pp_productType =", value, "ppProducttype");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeNotEqualTo(String value) {
            addCriterion("pp_productType <>", value, "ppProducttype");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeGreaterThan(String value) {
            addCriterion("pp_productType >", value, "ppProducttype");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeGreaterThanOrEqualTo(String value) {
            addCriterion("pp_productType >=", value, "ppProducttype");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeLessThan(String value) {
            addCriterion("pp_productType <", value, "ppProducttype");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeLessThanOrEqualTo(String value) {
            addCriterion("pp_productType <=", value, "ppProducttype");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeLike(String value) {
            addCriterion("pp_productType like", value, "ppProducttype");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeNotLike(String value) {
            addCriterion("pp_productType not like", value, "ppProducttype");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeIn(List<String> values) {
            addCriterion("pp_productType in", values, "ppProducttype");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeNotIn(List<String> values) {
            addCriterion("pp_productType not in", values, "ppProducttype");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeBetween(String value1, String value2) {
            addCriterion("pp_productType between", value1, value2, "ppProducttype");
            return (Criteria) this;
        }

        public Criteria andPpProducttypeNotBetween(String value1, String value2) {
            addCriterion("pp_productType not between", value1, value2, "ppProducttype");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplytimeIsNull() {
            addCriterion("pp_loanApplyTime is null");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplytimeIsNotNull() {
            addCriterion("pp_loanApplyTime is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplytimeEqualTo(Date value) {
            addCriterion("pp_loanApplyTime =", value, "ppLoanapplytime");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplytimeNotEqualTo(Date value) {
            addCriterion("pp_loanApplyTime <>", value, "ppLoanapplytime");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplytimeGreaterThan(Date value) {
            addCriterion("pp_loanApplyTime >", value, "ppLoanapplytime");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pp_loanApplyTime >=", value, "ppLoanapplytime");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplytimeLessThan(Date value) {
            addCriterion("pp_loanApplyTime <", value, "ppLoanapplytime");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplytimeLessThanOrEqualTo(Date value) {
            addCriterion("pp_loanApplyTime <=", value, "ppLoanapplytime");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplytimeIn(List<Date> values) {
            addCriterion("pp_loanApplyTime in", values, "ppLoanapplytime");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplytimeNotIn(List<Date> values) {
            addCriterion("pp_loanApplyTime not in", values, "ppLoanapplytime");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplytimeBetween(Date value1, Date value2) {
            addCriterion("pp_loanApplyTime between", value1, value2, "ppLoanapplytime");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplytimeNotBetween(Date value1, Date value2) {
            addCriterion("pp_loanApplyTime not between", value1, value2, "ppLoanapplytime");
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

        public Criteria andPpLoanamountEqualTo(Long value) {
            addCriterion("pp_loanAmount =", value, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountNotEqualTo(Long value) {
            addCriterion("pp_loanAmount <>", value, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountGreaterThan(Long value) {
            addCriterion("pp_loanAmount >", value, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountGreaterThanOrEqualTo(Long value) {
            addCriterion("pp_loanAmount >=", value, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountLessThan(Long value) {
            addCriterion("pp_loanAmount <", value, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountLessThanOrEqualTo(Long value) {
            addCriterion("pp_loanAmount <=", value, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountIn(List<Long> values) {
            addCriterion("pp_loanAmount in", values, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountNotIn(List<Long> values) {
            addCriterion("pp_loanAmount not in", values, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountBetween(Long value1, Long value2) {
            addCriterion("pp_loanAmount between", value1, value2, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanamountNotBetween(Long value1, Long value2) {
            addCriterion("pp_loanAmount not between", value1, value2, "ppLoanamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanmanagefeerateIsNull() {
            addCriterion("pp_loanManageFeeRate is null");
            return (Criteria) this;
        }

        public Criteria andPpLoanmanagefeerateIsNotNull() {
            addCriterion("pp_loanManageFeeRate is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoanmanagefeerateEqualTo(Long value) {
            addCriterion("pp_loanManageFeeRate =", value, "ppLoanmanagefeerate");
            return (Criteria) this;
        }

        public Criteria andPpLoanmanagefeerateNotEqualTo(Long value) {
            addCriterion("pp_loanManageFeeRate <>", value, "ppLoanmanagefeerate");
            return (Criteria) this;
        }

        public Criteria andPpLoanmanagefeerateGreaterThan(Long value) {
            addCriterion("pp_loanManageFeeRate >", value, "ppLoanmanagefeerate");
            return (Criteria) this;
        }

        public Criteria andPpLoanmanagefeerateGreaterThanOrEqualTo(Long value) {
            addCriterion("pp_loanManageFeeRate >=", value, "ppLoanmanagefeerate");
            return (Criteria) this;
        }

        public Criteria andPpLoanmanagefeerateLessThan(Long value) {
            addCriterion("pp_loanManageFeeRate <", value, "ppLoanmanagefeerate");
            return (Criteria) this;
        }

        public Criteria andPpLoanmanagefeerateLessThanOrEqualTo(Long value) {
            addCriterion("pp_loanManageFeeRate <=", value, "ppLoanmanagefeerate");
            return (Criteria) this;
        }

        public Criteria andPpLoanmanagefeerateIn(List<Long> values) {
            addCriterion("pp_loanManageFeeRate in", values, "ppLoanmanagefeerate");
            return (Criteria) this;
        }

        public Criteria andPpLoanmanagefeerateNotIn(List<Long> values) {
            addCriterion("pp_loanManageFeeRate not in", values, "ppLoanmanagefeerate");
            return (Criteria) this;
        }

        public Criteria andPpLoanmanagefeerateBetween(Long value1, Long value2) {
            addCriterion("pp_loanManageFeeRate between", value1, value2, "ppLoanmanagefeerate");
            return (Criteria) this;
        }

        public Criteria andPpLoanmanagefeerateNotBetween(Long value1, Long value2) {
            addCriterion("pp_loanManageFeeRate not between", value1, value2, "ppLoanmanagefeerate");
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

        public Criteria andPpComprehensiverateEqualTo(Long value) {
            addCriterion("pp_comprehensiveRate =", value, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateNotEqualTo(Long value) {
            addCriterion("pp_comprehensiveRate <>", value, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateGreaterThan(Long value) {
            addCriterion("pp_comprehensiveRate >", value, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateGreaterThanOrEqualTo(Long value) {
            addCriterion("pp_comprehensiveRate >=", value, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateLessThan(Long value) {
            addCriterion("pp_comprehensiveRate <", value, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateLessThanOrEqualTo(Long value) {
            addCriterion("pp_comprehensiveRate <=", value, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateIn(List<Long> values) {
            addCriterion("pp_comprehensiveRate in", values, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateNotIn(List<Long> values) {
            addCriterion("pp_comprehensiveRate not in", values, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateBetween(Long value1, Long value2) {
            addCriterion("pp_comprehensiveRate between", value1, value2, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpComprehensiverateNotBetween(Long value1, Long value2) {
            addCriterion("pp_comprehensiveRate not between", value1, value2, "ppComprehensiverate");
            return (Criteria) this;
        }

        public Criteria andPpLoandescIsNull() {
            addCriterion("pp_loanDesc is null");
            return (Criteria) this;
        }

        public Criteria andPpLoandescIsNotNull() {
            addCriterion("pp_loanDesc is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoandescEqualTo(String value) {
            addCriterion("pp_loanDesc =", value, "ppLoandesc");
            return (Criteria) this;
        }

        public Criteria andPpLoandescNotEqualTo(String value) {
            addCriterion("pp_loanDesc <>", value, "ppLoandesc");
            return (Criteria) this;
        }

        public Criteria andPpLoandescGreaterThan(String value) {
            addCriterion("pp_loanDesc >", value, "ppLoandesc");
            return (Criteria) this;
        }

        public Criteria andPpLoandescGreaterThanOrEqualTo(String value) {
            addCriterion("pp_loanDesc >=", value, "ppLoandesc");
            return (Criteria) this;
        }

        public Criteria andPpLoandescLessThan(String value) {
            addCriterion("pp_loanDesc <", value, "ppLoandesc");
            return (Criteria) this;
        }

        public Criteria andPpLoandescLessThanOrEqualTo(String value) {
            addCriterion("pp_loanDesc <=", value, "ppLoandesc");
            return (Criteria) this;
        }

        public Criteria andPpLoandescLike(String value) {
            addCriterion("pp_loanDesc like", value, "ppLoandesc");
            return (Criteria) this;
        }

        public Criteria andPpLoandescNotLike(String value) {
            addCriterion("pp_loanDesc not like", value, "ppLoandesc");
            return (Criteria) this;
        }

        public Criteria andPpLoandescIn(List<String> values) {
            addCriterion("pp_loanDesc in", values, "ppLoandesc");
            return (Criteria) this;
        }

        public Criteria andPpLoandescNotIn(List<String> values) {
            addCriterion("pp_loanDesc not in", values, "ppLoandesc");
            return (Criteria) this;
        }

        public Criteria andPpLoandescBetween(String value1, String value2) {
            addCriterion("pp_loanDesc between", value1, value2, "ppLoandesc");
            return (Criteria) this;
        }

        public Criteria andPpLoandescNotBetween(String value1, String value2) {
            addCriterion("pp_loanDesc not between", value1, value2, "ppLoandesc");
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

        public Criteria andPpLoanapplystatusIsNull() {
            addCriterion("pp_loanApplyStatus is null");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplystatusIsNotNull() {
            addCriterion("pp_loanApplyStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplystatusEqualTo(Integer value) {
            addCriterion("pp_loanApplyStatus =", value, "ppLoanapplystatus");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplystatusNotEqualTo(Integer value) {
            addCriterion("pp_loanApplyStatus <>", value, "ppLoanapplystatus");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplystatusGreaterThan(Integer value) {
            addCriterion("pp_loanApplyStatus >", value, "ppLoanapplystatus");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplystatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_loanApplyStatus >=", value, "ppLoanapplystatus");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplystatusLessThan(Integer value) {
            addCriterion("pp_loanApplyStatus <", value, "ppLoanapplystatus");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplystatusLessThanOrEqualTo(Integer value) {
            addCriterion("pp_loanApplyStatus <=", value, "ppLoanapplystatus");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplystatusIn(List<Integer> values) {
            addCriterion("pp_loanApplyStatus in", values, "ppLoanapplystatus");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplystatusNotIn(List<Integer> values) {
            addCriterion("pp_loanApplyStatus not in", values, "ppLoanapplystatus");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplystatusBetween(Integer value1, Integer value2) {
            addCriterion("pp_loanApplyStatus between", value1, value2, "ppLoanapplystatus");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplystatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_loanApplyStatus not between", value1, value2, "ppLoanapplystatus");
            return (Criteria) this;
        }

        public Criteria andPpLoangranttimeIsNull() {
            addCriterion("pp_loanGrantTime is null");
            return (Criteria) this;
        }

        public Criteria andPpLoangranttimeIsNotNull() {
            addCriterion("pp_loanGrantTime is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoangranttimeEqualTo(Date value) {
            addCriterion("pp_loanGrantTime =", value, "ppLoangranttime");
            return (Criteria) this;
        }

        public Criteria andPpLoangranttimeNotEqualTo(Date value) {
            addCriterion("pp_loanGrantTime <>", value, "ppLoangranttime");
            return (Criteria) this;
        }

        public Criteria andPpLoangranttimeGreaterThan(Date value) {
            addCriterion("pp_loanGrantTime >", value, "ppLoangranttime");
            return (Criteria) this;
        }

        public Criteria andPpLoangranttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pp_loanGrantTime >=", value, "ppLoangranttime");
            return (Criteria) this;
        }

        public Criteria andPpLoangranttimeLessThan(Date value) {
            addCriterion("pp_loanGrantTime <", value, "ppLoangranttime");
            return (Criteria) this;
        }

        public Criteria andPpLoangranttimeLessThanOrEqualTo(Date value) {
            addCriterion("pp_loanGrantTime <=", value, "ppLoangranttime");
            return (Criteria) this;
        }

        public Criteria andPpLoangranttimeIn(List<Date> values) {
            addCriterion("pp_loanGrantTime in", values, "ppLoangranttime");
            return (Criteria) this;
        }

        public Criteria andPpLoangranttimeNotIn(List<Date> values) {
            addCriterion("pp_loanGrantTime not in", values, "ppLoangranttime");
            return (Criteria) this;
        }

        public Criteria andPpLoangranttimeBetween(Date value1, Date value2) {
            addCriterion("pp_loanGrantTime between", value1, value2, "ppLoangranttime");
            return (Criteria) this;
        }

        public Criteria andPpLoangranttimeNotBetween(Date value1, Date value2) {
            addCriterion("pp_loanGrantTime not between", value1, value2, "ppLoangranttime");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymenttimeIsNull() {
            addCriterion("pp_loanRepaymentTime is null");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymenttimeIsNotNull() {
            addCriterion("pp_loanRepaymentTime is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymenttimeEqualTo(Date value) {
            addCriterion("pp_loanRepaymentTime =", value, "ppLoanrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymenttimeNotEqualTo(Date value) {
            addCriterion("pp_loanRepaymentTime <>", value, "ppLoanrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymenttimeGreaterThan(Date value) {
            addCriterion("pp_loanRepaymentTime >", value, "ppLoanrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pp_loanRepaymentTime >=", value, "ppLoanrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymenttimeLessThan(Date value) {
            addCriterion("pp_loanRepaymentTime <", value, "ppLoanrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymenttimeLessThanOrEqualTo(Date value) {
            addCriterion("pp_loanRepaymentTime <=", value, "ppLoanrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymenttimeIn(List<Date> values) {
            addCriterion("pp_loanRepaymentTime in", values, "ppLoanrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymenttimeNotIn(List<Date> values) {
            addCriterion("pp_loanRepaymentTime not in", values, "ppLoanrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymenttimeBetween(Date value1, Date value2) {
            addCriterion("pp_loanRepaymentTime between", value1, value2, "ppLoanrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPpLoanrepaymenttimeNotBetween(Date value1, Date value2) {
            addCriterion("pp_loanRepaymentTime not between", value1, value2, "ppLoanrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeIsNull() {
            addCriterion("pp_loanPurpose is null");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeIsNotNull() {
            addCriterion("pp_loanPurpose is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeEqualTo(String value) {
            addCriterion("pp_loanPurpose =", value, "ppLoanpurpose");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeNotEqualTo(String value) {
            addCriterion("pp_loanPurpose <>", value, "ppLoanpurpose");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeGreaterThan(String value) {
            addCriterion("pp_loanPurpose >", value, "ppLoanpurpose");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeGreaterThanOrEqualTo(String value) {
            addCriterion("pp_loanPurpose >=", value, "ppLoanpurpose");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeLessThan(String value) {
            addCriterion("pp_loanPurpose <", value, "ppLoanpurpose");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeLessThanOrEqualTo(String value) {
            addCriterion("pp_loanPurpose <=", value, "ppLoanpurpose");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeLike(String value) {
            addCriterion("pp_loanPurpose like", value, "ppLoanpurpose");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeNotLike(String value) {
            addCriterion("pp_loanPurpose not like", value, "ppLoanpurpose");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeIn(List<String> values) {
            addCriterion("pp_loanPurpose in", values, "ppLoanpurpose");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeNotIn(List<String> values) {
            addCriterion("pp_loanPurpose not in", values, "ppLoanpurpose");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeBetween(String value1, String value2) {
            addCriterion("pp_loanPurpose between", value1, value2, "ppLoanpurpose");
            return (Criteria) this;
        }

        public Criteria andPpLoanpurposeNotBetween(String value1, String value2) {
            addCriterion("pp_loanPurpose not between", value1, value2, "ppLoanpurpose");
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

        public Criteria andPpRepaymentamountIsNull() {
            addCriterion("pp_repaymentAmount is null");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountIsNotNull() {
            addCriterion("pp_repaymentAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountEqualTo(Long value) {
            addCriterion("pp_repaymentAmount =", value, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountNotEqualTo(Long value) {
            addCriterion("pp_repaymentAmount <>", value, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountGreaterThan(Long value) {
            addCriterion("pp_repaymentAmount >", value, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountGreaterThanOrEqualTo(Long value) {
            addCriterion("pp_repaymentAmount >=", value, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountLessThan(Long value) {
            addCriterion("pp_repaymentAmount <", value, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountLessThanOrEqualTo(Long value) {
            addCriterion("pp_repaymentAmount <=", value, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountIn(List<Long> values) {
            addCriterion("pp_repaymentAmount in", values, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountNotIn(List<Long> values) {
            addCriterion("pp_repaymentAmount not in", values, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountBetween(Long value1, Long value2) {
            addCriterion("pp_repaymentAmount between", value1, value2, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpRepaymentamountNotBetween(Long value1, Long value2) {
            addCriterion("pp_repaymentAmount not between", value1, value2, "ppRepaymentamount");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileIsNull() {
            addCriterion("pp_loanApplyMobile is null");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileIsNotNull() {
            addCriterion("pp_loanApplyMobile is not null");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileEqualTo(String value) {
            addCriterion("pp_loanApplyMobile =", value, "ppLoanapplymobile");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileNotEqualTo(String value) {
            addCriterion("pp_loanApplyMobile <>", value, "ppLoanapplymobile");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileGreaterThan(String value) {
            addCriterion("pp_loanApplyMobile >", value, "ppLoanapplymobile");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileGreaterThanOrEqualTo(String value) {
            addCriterion("pp_loanApplyMobile >=", value, "ppLoanapplymobile");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileLessThan(String value) {
            addCriterion("pp_loanApplyMobile <", value, "ppLoanapplymobile");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileLessThanOrEqualTo(String value) {
            addCriterion("pp_loanApplyMobile <=", value, "ppLoanapplymobile");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileLike(String value) {
            addCriterion("pp_loanApplyMobile like", value, "ppLoanapplymobile");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileNotLike(String value) {
            addCriterion("pp_loanApplyMobile not like", value, "ppLoanapplymobile");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileIn(List<String> values) {
            addCriterion("pp_loanApplyMobile in", values, "ppLoanapplymobile");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileNotIn(List<String> values) {
            addCriterion("pp_loanApplyMobile not in", values, "ppLoanapplymobile");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileBetween(String value1, String value2) {
            addCriterion("pp_loanApplyMobile between", value1, value2, "ppLoanapplymobile");
            return (Criteria) this;
        }

        public Criteria andPpLoanapplymobileNotBetween(String value1, String value2) {
            addCriterion("pp_loanApplyMobile not between", value1, value2, "ppLoanapplymobile");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoIsNull() {
            addCriterion("pp_guaranteeInfo is null");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoIsNotNull() {
            addCriterion("pp_guaranteeInfo is not null");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoEqualTo(String value) {
            addCriterion("pp_guaranteeInfo =", value, "ppGuaranteeinfo");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoNotEqualTo(String value) {
            addCriterion("pp_guaranteeInfo <>", value, "ppGuaranteeinfo");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoGreaterThan(String value) {
            addCriterion("pp_guaranteeInfo >", value, "ppGuaranteeinfo");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoGreaterThanOrEqualTo(String value) {
            addCriterion("pp_guaranteeInfo >=", value, "ppGuaranteeinfo");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoLessThan(String value) {
            addCriterion("pp_guaranteeInfo <", value, "ppGuaranteeinfo");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoLessThanOrEqualTo(String value) {
            addCriterion("pp_guaranteeInfo <=", value, "ppGuaranteeinfo");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoLike(String value) {
            addCriterion("pp_guaranteeInfo like", value, "ppGuaranteeinfo");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoNotLike(String value) {
            addCriterion("pp_guaranteeInfo not like", value, "ppGuaranteeinfo");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoIn(List<String> values) {
            addCriterion("pp_guaranteeInfo in", values, "ppGuaranteeinfo");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoNotIn(List<String> values) {
            addCriterion("pp_guaranteeInfo not in", values, "ppGuaranteeinfo");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoBetween(String value1, String value2) {
            addCriterion("pp_guaranteeInfo between", value1, value2, "ppGuaranteeinfo");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteeinfoNotBetween(String value1, String value2) {
            addCriterion("pp_guaranteeInfo not between", value1, value2, "ppGuaranteeinfo");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoIsNull() {
            addCriterion("pp_mortgageInfo is null");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoIsNotNull() {
            addCriterion("pp_mortgageInfo is not null");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoEqualTo(String value) {
            addCriterion("pp_mortgageInfo =", value, "ppMortgageinfo");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoNotEqualTo(String value) {
            addCriterion("pp_mortgageInfo <>", value, "ppMortgageinfo");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoGreaterThan(String value) {
            addCriterion("pp_mortgageInfo >", value, "ppMortgageinfo");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoGreaterThanOrEqualTo(String value) {
            addCriterion("pp_mortgageInfo >=", value, "ppMortgageinfo");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoLessThan(String value) {
            addCriterion("pp_mortgageInfo <", value, "ppMortgageinfo");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoLessThanOrEqualTo(String value) {
            addCriterion("pp_mortgageInfo <=", value, "ppMortgageinfo");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoLike(String value) {
            addCriterion("pp_mortgageInfo like", value, "ppMortgageinfo");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoNotLike(String value) {
            addCriterion("pp_mortgageInfo not like", value, "ppMortgageinfo");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoIn(List<String> values) {
            addCriterion("pp_mortgageInfo in", values, "ppMortgageinfo");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoNotIn(List<String> values) {
            addCriterion("pp_mortgageInfo not in", values, "ppMortgageinfo");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoBetween(String value1, String value2) {
            addCriterion("pp_mortgageInfo between", value1, value2, "ppMortgageinfo");
            return (Criteria) this;
        }

        public Criteria andPpMortgageinfoNotBetween(String value1, String value2) {
            addCriterion("pp_mortgageInfo not between", value1, value2, "ppMortgageinfo");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureIsNull() {
            addCriterion("pp_riskMeasure is null");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureIsNotNull() {
            addCriterion("pp_riskMeasure is not null");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureEqualTo(String value) {
            addCriterion("pp_riskMeasure =", value, "ppRiskmeasure");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureNotEqualTo(String value) {
            addCriterion("pp_riskMeasure <>", value, "ppRiskmeasure");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureGreaterThan(String value) {
            addCriterion("pp_riskMeasure >", value, "ppRiskmeasure");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureGreaterThanOrEqualTo(String value) {
            addCriterion("pp_riskMeasure >=", value, "ppRiskmeasure");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureLessThan(String value) {
            addCriterion("pp_riskMeasure <", value, "ppRiskmeasure");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureLessThanOrEqualTo(String value) {
            addCriterion("pp_riskMeasure <=", value, "ppRiskmeasure");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureLike(String value) {
            addCriterion("pp_riskMeasure like", value, "ppRiskmeasure");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureNotLike(String value) {
            addCriterion("pp_riskMeasure not like", value, "ppRiskmeasure");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureIn(List<String> values) {
            addCriterion("pp_riskMeasure in", values, "ppRiskmeasure");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureNotIn(List<String> values) {
            addCriterion("pp_riskMeasure not in", values, "ppRiskmeasure");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureBetween(String value1, String value2) {
            addCriterion("pp_riskMeasure between", value1, value2, "ppRiskmeasure");
            return (Criteria) this;
        }

        public Criteria andPpRiskmeasureNotBetween(String value1, String value2) {
            addCriterion("pp_riskMeasure not between", value1, value2, "ppRiskmeasure");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteefeerateIsNull() {
            addCriterion("pp_guaranteeFeeRate is null");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteefeerateIsNotNull() {
            addCriterion("pp_guaranteeFeeRate is not null");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteefeerateEqualTo(Long value) {
            addCriterion("pp_guaranteeFeeRate =", value, "ppGuaranteefeerate");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteefeerateNotEqualTo(Long value) {
            addCriterion("pp_guaranteeFeeRate <>", value, "ppGuaranteefeerate");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteefeerateGreaterThan(Long value) {
            addCriterion("pp_guaranteeFeeRate >", value, "ppGuaranteefeerate");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteefeerateGreaterThanOrEqualTo(Long value) {
            addCriterion("pp_guaranteeFeeRate >=", value, "ppGuaranteefeerate");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteefeerateLessThan(Long value) {
            addCriterion("pp_guaranteeFeeRate <", value, "ppGuaranteefeerate");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteefeerateLessThanOrEqualTo(Long value) {
            addCriterion("pp_guaranteeFeeRate <=", value, "ppGuaranteefeerate");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteefeerateIn(List<Long> values) {
            addCriterion("pp_guaranteeFeeRate in", values, "ppGuaranteefeerate");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteefeerateNotIn(List<Long> values) {
            addCriterion("pp_guaranteeFeeRate not in", values, "ppGuaranteefeerate");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteefeerateBetween(Long value1, Long value2) {
            addCriterion("pp_guaranteeFeeRate between", value1, value2, "ppGuaranteefeerate");
            return (Criteria) this;
        }

        public Criteria andPpGuaranteefeerateNotBetween(Long value1, Long value2) {
            addCriterion("pp_guaranteeFeeRate not between", value1, value2, "ppGuaranteefeerate");
            return (Criteria) this;
        }

        public Criteria andPpServicefeerateIsNull() {
            addCriterion("pp_serviceFeeRate is null");
            return (Criteria) this;
        }

        public Criteria andPpServicefeerateIsNotNull() {
            addCriterion("pp_serviceFeeRate is not null");
            return (Criteria) this;
        }

        public Criteria andPpServicefeerateEqualTo(Long value) {
            addCriterion("pp_serviceFeeRate =", value, "ppServicefeerate");
            return (Criteria) this;
        }

        public Criteria andPpServicefeerateNotEqualTo(Long value) {
            addCriterion("pp_serviceFeeRate <>", value, "ppServicefeerate");
            return (Criteria) this;
        }

        public Criteria andPpServicefeerateGreaterThan(Long value) {
            addCriterion("pp_serviceFeeRate >", value, "ppServicefeerate");
            return (Criteria) this;
        }

        public Criteria andPpServicefeerateGreaterThanOrEqualTo(Long value) {
            addCriterion("pp_serviceFeeRate >=", value, "ppServicefeerate");
            return (Criteria) this;
        }

        public Criteria andPpServicefeerateLessThan(Long value) {
            addCriterion("pp_serviceFeeRate <", value, "ppServicefeerate");
            return (Criteria) this;
        }

        public Criteria andPpServicefeerateLessThanOrEqualTo(Long value) {
            addCriterion("pp_serviceFeeRate <=", value, "ppServicefeerate");
            return (Criteria) this;
        }

        public Criteria andPpServicefeerateIn(List<Long> values) {
            addCriterion("pp_serviceFeeRate in", values, "ppServicefeerate");
            return (Criteria) this;
        }

        public Criteria andPpServicefeerateNotIn(List<Long> values) {
            addCriterion("pp_serviceFeeRate not in", values, "ppServicefeerate");
            return (Criteria) this;
        }

        public Criteria andPpServicefeerateBetween(Long value1, Long value2) {
            addCriterion("pp_serviceFeeRate between", value1, value2, "ppServicefeerate");
            return (Criteria) this;
        }

        public Criteria andPpServicefeerateNotBetween(Long value1, Long value2) {
            addCriterion("pp_serviceFeeRate not between", value1, value2, "ppServicefeerate");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountrateIsNull() {
            addCriterion("pp_riskManageAmountRate is null");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountrateIsNotNull() {
            addCriterion("pp_riskManageAmountRate is not null");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountrateEqualTo(Long value) {
            addCriterion("pp_riskManageAmountRate =", value, "ppRiskmanageamountrate");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountrateNotEqualTo(Long value) {
            addCriterion("pp_riskManageAmountRate <>", value, "ppRiskmanageamountrate");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountrateGreaterThan(Long value) {
            addCriterion("pp_riskManageAmountRate >", value, "ppRiskmanageamountrate");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountrateGreaterThanOrEqualTo(Long value) {
            addCriterion("pp_riskManageAmountRate >=", value, "ppRiskmanageamountrate");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountrateLessThan(Long value) {
            addCriterion("pp_riskManageAmountRate <", value, "ppRiskmanageamountrate");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountrateLessThanOrEqualTo(Long value) {
            addCriterion("pp_riskManageAmountRate <=", value, "ppRiskmanageamountrate");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountrateIn(List<Long> values) {
            addCriterion("pp_riskManageAmountRate in", values, "ppRiskmanageamountrate");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountrateNotIn(List<Long> values) {
            addCriterion("pp_riskManageAmountRate not in", values, "ppRiskmanageamountrate");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountrateBetween(Long value1, Long value2) {
            addCriterion("pp_riskManageAmountRate between", value1, value2, "ppRiskmanageamountrate");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountrateNotBetween(Long value1, Long value2) {
            addCriterion("pp_riskManageAmountRate not between", value1, value2, "ppRiskmanageamountrate");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountIsNull() {
            addCriterion("pp_riskManageAmount is null");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountIsNotNull() {
            addCriterion("pp_riskManageAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountEqualTo(Long value) {
            addCriterion("pp_riskManageAmount =", value, "ppRiskmanageamount");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountNotEqualTo(Long value) {
            addCriterion("pp_riskManageAmount <>", value, "ppRiskmanageamount");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountGreaterThan(Long value) {
            addCriterion("pp_riskManageAmount >", value, "ppRiskmanageamount");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountGreaterThanOrEqualTo(Long value) {
            addCriterion("pp_riskManageAmount >=", value, "ppRiskmanageamount");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountLessThan(Long value) {
            addCriterion("pp_riskManageAmount <", value, "ppRiskmanageamount");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountLessThanOrEqualTo(Long value) {
            addCriterion("pp_riskManageAmount <=", value, "ppRiskmanageamount");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountIn(List<Long> values) {
            addCriterion("pp_riskManageAmount in", values, "ppRiskmanageamount");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountNotIn(List<Long> values) {
            addCriterion("pp_riskManageAmount not in", values, "ppRiskmanageamount");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountBetween(Long value1, Long value2) {
            addCriterion("pp_riskManageAmount between", value1, value2, "ppRiskmanageamount");
            return (Criteria) this;
        }

        public Criteria andPpRiskmanageamountNotBetween(Long value1, Long value2) {
            addCriterion("pp_riskManageAmount not between", value1, value2, "ppRiskmanageamount");
            return (Criteria) this;
        }

        public Criteria andPpInterestfeerateIsNull() {
            addCriterion("pp_interestFeeRate is null");
            return (Criteria) this;
        }

        public Criteria andPpInterestfeerateIsNotNull() {
            addCriterion("pp_interestFeeRate is not null");
            return (Criteria) this;
        }

        public Criteria andPpInterestfeerateEqualTo(Long value) {
            addCriterion("pp_interestFeeRate =", value, "ppInterestfeerate");
            return (Criteria) this;
        }

        public Criteria andPpInterestfeerateNotEqualTo(Long value) {
            addCriterion("pp_interestFeeRate <>", value, "ppInterestfeerate");
            return (Criteria) this;
        }

        public Criteria andPpInterestfeerateGreaterThan(Long value) {
            addCriterion("pp_interestFeeRate >", value, "ppInterestfeerate");
            return (Criteria) this;
        }

        public Criteria andPpInterestfeerateGreaterThanOrEqualTo(Long value) {
            addCriterion("pp_interestFeeRate >=", value, "ppInterestfeerate");
            return (Criteria) this;
        }

        public Criteria andPpInterestfeerateLessThan(Long value) {
            addCriterion("pp_interestFeeRate <", value, "ppInterestfeerate");
            return (Criteria) this;
        }

        public Criteria andPpInterestfeerateLessThanOrEqualTo(Long value) {
            addCriterion("pp_interestFeeRate <=", value, "ppInterestfeerate");
            return (Criteria) this;
        }

        public Criteria andPpInterestfeerateIn(List<Long> values) {
            addCriterion("pp_interestFeeRate in", values, "ppInterestfeerate");
            return (Criteria) this;
        }

        public Criteria andPpInterestfeerateNotIn(List<Long> values) {
            addCriterion("pp_interestFeeRate not in", values, "ppInterestfeerate");
            return (Criteria) this;
        }

        public Criteria andPpInterestfeerateBetween(Long value1, Long value2) {
            addCriterion("pp_interestFeeRate between", value1, value2, "ppInterestfeerate");
            return (Criteria) this;
        }

        public Criteria andPpInterestfeerateNotBetween(Long value1, Long value2) {
            addCriterion("pp_interestFeeRate not between", value1, value2, "ppInterestfeerate");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameIsNull() {
            addCriterion("pp_principalName is null");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameIsNotNull() {
            addCriterion("pp_principalName is not null");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameEqualTo(String value) {
            addCriterion("pp_principalName =", value, "ppPrincipalname");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameNotEqualTo(String value) {
            addCriterion("pp_principalName <>", value, "ppPrincipalname");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameGreaterThan(String value) {
            addCriterion("pp_principalName >", value, "ppPrincipalname");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameGreaterThanOrEqualTo(String value) {
            addCriterion("pp_principalName >=", value, "ppPrincipalname");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameLessThan(String value) {
            addCriterion("pp_principalName <", value, "ppPrincipalname");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameLessThanOrEqualTo(String value) {
            addCriterion("pp_principalName <=", value, "ppPrincipalname");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameLike(String value) {
            addCriterion("pp_principalName like", value, "ppPrincipalname");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameNotLike(String value) {
            addCriterion("pp_principalName not like", value, "ppPrincipalname");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameIn(List<String> values) {
            addCriterion("pp_principalName in", values, "ppPrincipalname");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameNotIn(List<String> values) {
            addCriterion("pp_principalName not in", values, "ppPrincipalname");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameBetween(String value1, String value2) {
            addCriterion("pp_principalName between", value1, value2, "ppPrincipalname");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalnameNotBetween(String value1, String value2) {
            addCriterion("pp_principalName not between", value1, value2, "ppPrincipalname");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardIsNull() {
            addCriterion("pp_principalIdCard is null");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardIsNotNull() {
            addCriterion("pp_principalIdCard is not null");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardEqualTo(String value) {
            addCriterion("pp_principalIdCard =", value, "ppPrincipalidcard");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardNotEqualTo(String value) {
            addCriterion("pp_principalIdCard <>", value, "ppPrincipalidcard");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardGreaterThan(String value) {
            addCriterion("pp_principalIdCard >", value, "ppPrincipalidcard");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardGreaterThanOrEqualTo(String value) {
            addCriterion("pp_principalIdCard >=", value, "ppPrincipalidcard");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardLessThan(String value) {
            addCriterion("pp_principalIdCard <", value, "ppPrincipalidcard");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardLessThanOrEqualTo(String value) {
            addCriterion("pp_principalIdCard <=", value, "ppPrincipalidcard");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardLike(String value) {
            addCriterion("pp_principalIdCard like", value, "ppPrincipalidcard");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardNotLike(String value) {
            addCriterion("pp_principalIdCard not like", value, "ppPrincipalidcard");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardIn(List<String> values) {
            addCriterion("pp_principalIdCard in", values, "ppPrincipalidcard");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardNotIn(List<String> values) {
            addCriterion("pp_principalIdCard not in", values, "ppPrincipalidcard");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardBetween(String value1, String value2) {
            addCriterion("pp_principalIdCard between", value1, value2, "ppPrincipalidcard");
            return (Criteria) this;
        }

        public Criteria andPpPrincipalidcardNotBetween(String value1, String value2) {
            addCriterion("pp_principalIdCard not between", value1, value2, "ppPrincipalidcard");
            return (Criteria) this;
        }

        public Criteria andPpApplytypeIsNull() {
            addCriterion("pp_applyType is null");
            return (Criteria) this;
        }

        public Criteria andPpApplytypeIsNotNull() {
            addCriterion("pp_applyType is not null");
            return (Criteria) this;
        }

        public Criteria andPpApplytypeEqualTo(Integer value) {
            addCriterion("pp_applyType =", value, "ppApplytype");
            return (Criteria) this;
        }

        public Criteria andPpApplytypeNotEqualTo(Integer value) {
            addCriterion("pp_applyType <>", value, "ppApplytype");
            return (Criteria) this;
        }

        public Criteria andPpApplytypeGreaterThan(Integer value) {
            addCriterion("pp_applyType >", value, "ppApplytype");
            return (Criteria) this;
        }

        public Criteria andPpApplytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pp_applyType >=", value, "ppApplytype");
            return (Criteria) this;
        }

        public Criteria andPpApplytypeLessThan(Integer value) {
            addCriterion("pp_applyType <", value, "ppApplytype");
            return (Criteria) this;
        }

        public Criteria andPpApplytypeLessThanOrEqualTo(Integer value) {
            addCriterion("pp_applyType <=", value, "ppApplytype");
            return (Criteria) this;
        }

        public Criteria andPpApplytypeIn(List<Integer> values) {
            addCriterion("pp_applyType in", values, "ppApplytype");
            return (Criteria) this;
        }

        public Criteria andPpApplytypeNotIn(List<Integer> values) {
            addCriterion("pp_applyType not in", values, "ppApplytype");
            return (Criteria) this;
        }

        public Criteria andPpApplytypeBetween(Integer value1, Integer value2) {
            addCriterion("pp_applyType between", value1, value2, "ppApplytype");
            return (Criteria) this;
        }

        public Criteria andPpApplytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pp_applyType not between", value1, value2, "ppApplytype");
            return (Criteria) this;
        }

        public Criteria andPpRemarkIsNull() {
            addCriterion("pp_remark is null");
            return (Criteria) this;
        }

        public Criteria andPpRemarkIsNotNull() {
            addCriterion("pp_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPpRemarkEqualTo(String value) {
            addCriterion("pp_remark =", value, "ppRemark");
            return (Criteria) this;
        }

        public Criteria andPpRemarkNotEqualTo(String value) {
            addCriterion("pp_remark <>", value, "ppRemark");
            return (Criteria) this;
        }

        public Criteria andPpRemarkGreaterThan(String value) {
            addCriterion("pp_remark >", value, "ppRemark");
            return (Criteria) this;
        }

        public Criteria andPpRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("pp_remark >=", value, "ppRemark");
            return (Criteria) this;
        }

        public Criteria andPpRemarkLessThan(String value) {
            addCriterion("pp_remark <", value, "ppRemark");
            return (Criteria) this;
        }

        public Criteria andPpRemarkLessThanOrEqualTo(String value) {
            addCriterion("pp_remark <=", value, "ppRemark");
            return (Criteria) this;
        }

        public Criteria andPpRemarkLike(String value) {
            addCriterion("pp_remark like", value, "ppRemark");
            return (Criteria) this;
        }

        public Criteria andPpRemarkNotLike(String value) {
            addCriterion("pp_remark not like", value, "ppRemark");
            return (Criteria) this;
        }

        public Criteria andPpRemarkIn(List<String> values) {
            addCriterion("pp_remark in", values, "ppRemark");
            return (Criteria) this;
        }

        public Criteria andPpRemarkNotIn(List<String> values) {
            addCriterion("pp_remark not in", values, "ppRemark");
            return (Criteria) this;
        }

        public Criteria andPpRemarkBetween(String value1, String value2) {
            addCriterion("pp_remark between", value1, value2, "ppRemark");
            return (Criteria) this;
        }

        public Criteria andPpRemarkNotBetween(String value1, String value2) {
            addCriterion("pp_remark not between", value1, value2, "ppRemark");
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