package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_repayment_billExample implements Serializable{
    
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_repayment_billExample() {
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

        public Criteria andPrbRepaymentidIsNull() {
            addCriterion("prb_repaymentId is null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentidIsNotNull() {
            addCriterion("prb_repaymentId is not null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentidEqualTo(Long value) {
            addCriterion("prb_repaymentId =", value, "prbRepaymentid");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentidNotEqualTo(Long value) {
            addCriterion("prb_repaymentId <>", value, "prbRepaymentid");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentidGreaterThan(Long value) {
            addCriterion("prb_repaymentId >", value, "prbRepaymentid");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentidGreaterThanOrEqualTo(Long value) {
            addCriterion("prb_repaymentId >=", value, "prbRepaymentid");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentidLessThan(Long value) {
            addCriterion("prb_repaymentId <", value, "prbRepaymentid");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentidLessThanOrEqualTo(Long value) {
            addCriterion("prb_repaymentId <=", value, "prbRepaymentid");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentidIn(List<Long> values) {
            addCriterion("prb_repaymentId in", values, "prbRepaymentid");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentidNotIn(List<Long> values) {
            addCriterion("prb_repaymentId not in", values, "prbRepaymentid");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentidBetween(Long value1, Long value2) {
            addCriterion("prb_repaymentId between", value1, value2, "prbRepaymentid");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentidNotBetween(Long value1, Long value2) {
            addCriterion("prb_repaymentId not between", value1, value2, "prbRepaymentid");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoIsNull() {
            addCriterion("prb_repaybillNo is null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoIsNotNull() {
            addCriterion("prb_repaybillNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoEqualTo(String value) {
            addCriterion("prb_repaybillNo =", value, "prbRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoNotEqualTo(String value) {
            addCriterion("prb_repaybillNo <>", value, "prbRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoGreaterThan(String value) {
            addCriterion("prb_repaybillNo >", value, "prbRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoGreaterThanOrEqualTo(String value) {
            addCriterion("prb_repaybillNo >=", value, "prbRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoLessThan(String value) {
            addCriterion("prb_repaybillNo <", value, "prbRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoLessThanOrEqualTo(String value) {
            addCriterion("prb_repaybillNo <=", value, "prbRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoLike(String value) {
            addCriterion("prb_repaybillNo like", value, "prbRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoNotLike(String value) {
            addCriterion("prb_repaybillNo not like", value, "prbRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoIn(List<String> values) {
            addCriterion("prb_repaybillNo in", values, "prbRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoNotIn(List<String> values) {
            addCriterion("prb_repaybillNo not in", values, "prbRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoBetween(String value1, String value2) {
            addCriterion("prb_repaybillNo between", value1, value2, "prbRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrbRepaybillnoNotBetween(String value1, String value2) {
            addCriterion("prb_repaybillNo not between", value1, value2, "prbRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoIsNull() {
            addCriterion("prb_custNo is null");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoIsNotNull() {
            addCriterion("prb_custNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoEqualTo(String value) {
            addCriterion("prb_custNo =", value, "prbCustno");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoNotEqualTo(String value) {
            addCriterion("prb_custNo <>", value, "prbCustno");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoGreaterThan(String value) {
            addCriterion("prb_custNo >", value, "prbCustno");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoGreaterThanOrEqualTo(String value) {
            addCriterion("prb_custNo >=", value, "prbCustno");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoLessThan(String value) {
            addCriterion("prb_custNo <", value, "prbCustno");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoLessThanOrEqualTo(String value) {
            addCriterion("prb_custNo <=", value, "prbCustno");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoLike(String value) {
            addCriterion("prb_custNo like", value, "prbCustno");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoNotLike(String value) {
            addCriterion("prb_custNo not like", value, "prbCustno");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoIn(List<String> values) {
            addCriterion("prb_custNo in", values, "prbCustno");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoNotIn(List<String> values) {
            addCriterion("prb_custNo not in", values, "prbCustno");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoBetween(String value1, String value2) {
            addCriterion("prb_custNo between", value1, value2, "prbCustno");
            return (Criteria) this;
        }

        public Criteria andPrbCustnoNotBetween(String value1, String value2) {
            addCriterion("prb_custNo not between", value1, value2, "prbCustno");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberIsNull() {
            addCriterion("prb_bulkLoanNumber is null");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberIsNotNull() {
            addCriterion("prb_bulkLoanNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberEqualTo(String value) {
            addCriterion("prb_bulkLoanNumber =", value, "prbBulkloannumber");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberNotEqualTo(String value) {
            addCriterion("prb_bulkLoanNumber <>", value, "prbBulkloannumber");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberGreaterThan(String value) {
            addCriterion("prb_bulkLoanNumber >", value, "prbBulkloannumber");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberGreaterThanOrEqualTo(String value) {
            addCriterion("prb_bulkLoanNumber >=", value, "prbBulkloannumber");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberLessThan(String value) {
            addCriterion("prb_bulkLoanNumber <", value, "prbBulkloannumber");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberLessThanOrEqualTo(String value) {
            addCriterion("prb_bulkLoanNumber <=", value, "prbBulkloannumber");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberLike(String value) {
            addCriterion("prb_bulkLoanNumber like", value, "prbBulkloannumber");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberNotLike(String value) {
            addCriterion("prb_bulkLoanNumber not like", value, "prbBulkloannumber");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberIn(List<String> values) {
            addCriterion("prb_bulkLoanNumber in", values, "prbBulkloannumber");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberNotIn(List<String> values) {
            addCriterion("prb_bulkLoanNumber not in", values, "prbBulkloannumber");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberBetween(String value1, String value2) {
            addCriterion("prb_bulkLoanNumber between", value1, value2, "prbBulkloannumber");
            return (Criteria) this;
        }

        public Criteria andPrbBulkloannumberNotBetween(String value1, String value2) {
            addCriterion("prb_bulkLoanNumber not between", value1, value2, "prbBulkloannumber");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentseqIsNull() {
            addCriterion("prb_repaymentSeq is null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentseqIsNotNull() {
            addCriterion("prb_repaymentSeq is not null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentseqEqualTo(Integer value) {
            addCriterion("prb_repaymentSeq =", value, "prbRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentseqNotEqualTo(Integer value) {
            addCriterion("prb_repaymentSeq <>", value, "prbRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentseqGreaterThan(Integer value) {
            addCriterion("prb_repaymentSeq >", value, "prbRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentseqGreaterThanOrEqualTo(Integer value) {
            addCriterion("prb_repaymentSeq >=", value, "prbRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentseqLessThan(Integer value) {
            addCriterion("prb_repaymentSeq <", value, "prbRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentseqLessThanOrEqualTo(Integer value) {
            addCriterion("prb_repaymentSeq <=", value, "prbRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentseqIn(List<Integer> values) {
            addCriterion("prb_repaymentSeq in", values, "prbRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentseqNotIn(List<Integer> values) {
            addCriterion("prb_repaymentSeq not in", values, "prbRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentseqBetween(Integer value1, Integer value2) {
            addCriterion("prb_repaymentSeq between", value1, value2, "prbRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentseqNotBetween(Integer value1, Integer value2) {
            addCriterion("prb_repaymentSeq not between", value1, value2, "prbRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymenttimeIsNull() {
            addCriterion("prb_repaymentTime is null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymenttimeIsNotNull() {
            addCriterion("prb_repaymentTime is not null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymenttimeEqualTo(Date value) {
            addCriterion("prb_repaymentTime =", value, "prbRepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymenttimeNotEqualTo(Date value) {
            addCriterion("prb_repaymentTime <>", value, "prbRepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymenttimeGreaterThan(Date value) {
            addCriterion("prb_repaymentTime >", value, "prbRepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("prb_repaymentTime >=", value, "prbRepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymenttimeLessThan(Date value) {
            addCriterion("prb_repaymentTime <", value, "prbRepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymenttimeLessThanOrEqualTo(Date value) {
            addCriterion("prb_repaymentTime <=", value, "prbRepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymenttimeIn(List<Date> values) {
            addCriterion("prb_repaymentTime in", values, "prbRepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymenttimeNotIn(List<Date> values) {
            addCriterion("prb_repaymentTime not in", values, "prbRepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymenttimeBetween(Date value1, Date value2) {
            addCriterion("prb_repaymentTime between", value1, value2, "prbRepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymenttimeNotBetween(Date value1, Date value2) {
            addCriterion("prb_repaymentTime not between", value1, value2, "prbRepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentcapitalIsNull() {
            addCriterion("prb_repaymentCapital is null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentcapitalIsNotNull() {
            addCriterion("prb_repaymentCapital is not null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentcapitalEqualTo(BigDecimal value) {
            addCriterion("prb_repaymentCapital =", value, "prbRepaymentcapital");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentcapitalNotEqualTo(BigDecimal value) {
            addCriterion("prb_repaymentCapital <>", value, "prbRepaymentcapital");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentcapitalGreaterThan(BigDecimal value) {
            addCriterion("prb_repaymentCapital >", value, "prbRepaymentcapital");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentcapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_repaymentCapital >=", value, "prbRepaymentcapital");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentcapitalLessThan(BigDecimal value) {
            addCriterion("prb_repaymentCapital <", value, "prbRepaymentcapital");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentcapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_repaymentCapital <=", value, "prbRepaymentcapital");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentcapitalIn(List<BigDecimal> values) {
            addCriterion("prb_repaymentCapital in", values, "prbRepaymentcapital");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentcapitalNotIn(List<BigDecimal> values) {
            addCriterion("prb_repaymentCapital not in", values, "prbRepaymentcapital");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentcapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_repaymentCapital between", value1, value2, "prbRepaymentcapital");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentcapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_repaymentCapital not between", value1, value2, "prbRepaymentcapital");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentinterestIsNull() {
            addCriterion("prb_repaymentInterest is null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentinterestIsNotNull() {
            addCriterion("prb_repaymentInterest is not null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentinterestEqualTo(BigDecimal value) {
            addCriterion("prb_repaymentInterest =", value, "prbRepaymentinterest");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentinterestNotEqualTo(BigDecimal value) {
            addCriterion("prb_repaymentInterest <>", value, "prbRepaymentinterest");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentinterestGreaterThan(BigDecimal value) {
            addCriterion("prb_repaymentInterest >", value, "prbRepaymentinterest");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentinterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_repaymentInterest >=", value, "prbRepaymentinterest");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentinterestLessThan(BigDecimal value) {
            addCriterion("prb_repaymentInterest <", value, "prbRepaymentinterest");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentinterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_repaymentInterest <=", value, "prbRepaymentinterest");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentinterestIn(List<BigDecimal> values) {
            addCriterion("prb_repaymentInterest in", values, "prbRepaymentinterest");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentinterestNotIn(List<BigDecimal> values) {
            addCriterion("prb_repaymentInterest not in", values, "prbRepaymentinterest");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentinterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_repaymentInterest between", value1, value2, "prbRepaymentinterest");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentinterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_repaymentInterest not between", value1, value2, "prbRepaymentinterest");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentprincipalIsNull() {
            addCriterion("prb_repaymentPrincipal is null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentprincipalIsNotNull() {
            addCriterion("prb_repaymentPrincipal is not null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentprincipalEqualTo(BigDecimal value) {
            addCriterion("prb_repaymentPrincipal =", value, "prbRepaymentprincipal");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentprincipalNotEqualTo(BigDecimal value) {
            addCriterion("prb_repaymentPrincipal <>", value, "prbRepaymentprincipal");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentprincipalGreaterThan(BigDecimal value) {
            addCriterion("prb_repaymentPrincipal >", value, "prbRepaymentprincipal");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentprincipalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_repaymentPrincipal >=", value, "prbRepaymentprincipal");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentprincipalLessThan(BigDecimal value) {
            addCriterion("prb_repaymentPrincipal <", value, "prbRepaymentprincipal");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentprincipalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_repaymentPrincipal <=", value, "prbRepaymentprincipal");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentprincipalIn(List<BigDecimal> values) {
            addCriterion("prb_repaymentPrincipal in", values, "prbRepaymentprincipal");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentprincipalNotIn(List<BigDecimal> values) {
            addCriterion("prb_repaymentPrincipal not in", values, "prbRepaymentprincipal");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentprincipalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_repaymentPrincipal between", value1, value2, "prbRepaymentprincipal");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentprincipalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_repaymentPrincipal not between", value1, value2, "prbRepaymentprincipal");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymentpricipalIsNull() {
            addCriterion("prb_infactRepaymentPricipal is null");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymentpricipalIsNotNull() {
            addCriterion("prb_infactRepaymentPricipal is not null");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymentpricipalEqualTo(BigDecimal value) {
            addCriterion("prb_infactRepaymentPricipal =", value, "prbInfactrepaymentpricipal");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymentpricipalNotEqualTo(BigDecimal value) {
            addCriterion("prb_infactRepaymentPricipal <>", value, "prbInfactrepaymentpricipal");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymentpricipalGreaterThan(BigDecimal value) {
            addCriterion("prb_infactRepaymentPricipal >", value, "prbInfactrepaymentpricipal");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymentpricipalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_infactRepaymentPricipal >=", value, "prbInfactrepaymentpricipal");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymentpricipalLessThan(BigDecimal value) {
            addCriterion("prb_infactRepaymentPricipal <", value, "prbInfactrepaymentpricipal");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymentpricipalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_infactRepaymentPricipal <=", value, "prbInfactrepaymentpricipal");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymentpricipalIn(List<BigDecimal> values) {
            addCriterion("prb_infactRepaymentPricipal in", values, "prbInfactrepaymentpricipal");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymentpricipalNotIn(List<BigDecimal> values) {
            addCriterion("prb_infactRepaymentPricipal not in", values, "prbInfactrepaymentpricipal");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymentpricipalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_infactRepaymentPricipal between", value1, value2, "prbInfactrepaymentpricipal");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymentpricipalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_infactRepaymentPricipal not between", value1, value2, "prbInfactrepaymentpricipal");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymenttimeIsNull() {
            addCriterion("prb_infactRepaymentTime is null");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymenttimeIsNotNull() {
            addCriterion("prb_infactRepaymentTime is not null");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymenttimeEqualTo(BigDecimal value) {
            addCriterion("prb_infactRepaymentTime =", value, "prbInfactrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymenttimeNotEqualTo(BigDecimal value) {
            addCriterion("prb_infactRepaymentTime <>", value, "prbInfactrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymenttimeGreaterThan(BigDecimal value) {
            addCriterion("prb_infactRepaymentTime >", value, "prbInfactrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymenttimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_infactRepaymentTime >=", value, "prbInfactrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymenttimeLessThan(BigDecimal value) {
            addCriterion("prb_infactRepaymentTime <", value, "prbInfactrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymenttimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_infactRepaymentTime <=", value, "prbInfactrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymenttimeIn(List<BigDecimal> values) {
            addCriterion("prb_infactRepaymentTime in", values, "prbInfactrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymenttimeNotIn(List<BigDecimal> values) {
            addCriterion("prb_infactRepaymentTime not in", values, "prbInfactrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymenttimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_infactRepaymentTime between", value1, value2, "prbInfactrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbInfactrepaymenttimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_infactRepaymentTime not between", value1, value2, "prbInfactrepaymenttime");
            return (Criteria) this;
        }

        public Criteria andPrbOverduedaysIsNull() {
            addCriterion("prb_overDueDays is null");
            return (Criteria) this;
        }

        public Criteria andPrbOverduedaysIsNotNull() {
            addCriterion("prb_overDueDays is not null");
            return (Criteria) this;
        }

        public Criteria andPrbOverduedaysEqualTo(Integer value) {
            addCriterion("prb_overDueDays =", value, "prbOverduedays");
            return (Criteria) this;
        }

        public Criteria andPrbOverduedaysNotEqualTo(Integer value) {
            addCriterion("prb_overDueDays <>", value, "prbOverduedays");
            return (Criteria) this;
        }

        public Criteria andPrbOverduedaysGreaterThan(Integer value) {
            addCriterion("prb_overDueDays >", value, "prbOverduedays");
            return (Criteria) this;
        }

        public Criteria andPrbOverduedaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("prb_overDueDays >=", value, "prbOverduedays");
            return (Criteria) this;
        }

        public Criteria andPrbOverduedaysLessThan(Integer value) {
            addCriterion("prb_overDueDays <", value, "prbOverduedays");
            return (Criteria) this;
        }

        public Criteria andPrbOverduedaysLessThanOrEqualTo(Integer value) {
            addCriterion("prb_overDueDays <=", value, "prbOverduedays");
            return (Criteria) this;
        }

        public Criteria andPrbOverduedaysIn(List<Integer> values) {
            addCriterion("prb_overDueDays in", values, "prbOverduedays");
            return (Criteria) this;
        }

        public Criteria andPrbOverduedaysNotIn(List<Integer> values) {
            addCriterion("prb_overDueDays not in", values, "prbOverduedays");
            return (Criteria) this;
        }

        public Criteria andPrbOverduedaysBetween(Integer value1, Integer value2) {
            addCriterion("prb_overDueDays between", value1, value2, "prbOverduedays");
            return (Criteria) this;
        }

        public Criteria andPrbOverduedaysNotBetween(Integer value1, Integer value2) {
            addCriterion("prb_overDueDays not between", value1, value2, "prbOverduedays");
            return (Criteria) this;
        }

        public Criteria andPrbOverdueamountIsNull() {
            addCriterion("prb_overDueAmount is null");
            return (Criteria) this;
        }

        public Criteria andPrbOverdueamountIsNotNull() {
            addCriterion("prb_overDueAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPrbOverdueamountEqualTo(BigDecimal value) {
            addCriterion("prb_overDueAmount =", value, "prbOverdueamount");
            return (Criteria) this;
        }

        public Criteria andPrbOverdueamountNotEqualTo(BigDecimal value) {
            addCriterion("prb_overDueAmount <>", value, "prbOverdueamount");
            return (Criteria) this;
        }

        public Criteria andPrbOverdueamountGreaterThan(BigDecimal value) {
            addCriterion("prb_overDueAmount >", value, "prbOverdueamount");
            return (Criteria) this;
        }

        public Criteria andPrbOverdueamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_overDueAmount >=", value, "prbOverdueamount");
            return (Criteria) this;
        }

        public Criteria andPrbOverdueamountLessThan(BigDecimal value) {
            addCriterion("prb_overDueAmount <", value, "prbOverdueamount");
            return (Criteria) this;
        }

        public Criteria andPrbOverdueamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_overDueAmount <=", value, "prbOverdueamount");
            return (Criteria) this;
        }

        public Criteria andPrbOverdueamountIn(List<BigDecimal> values) {
            addCriterion("prb_overDueAmount in", values, "prbOverdueamount");
            return (Criteria) this;
        }

        public Criteria andPrbOverdueamountNotIn(List<BigDecimal> values) {
            addCriterion("prb_overDueAmount not in", values, "prbOverdueamount");
            return (Criteria) this;
        }

        public Criteria andPrbOverdueamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_overDueAmount between", value1, value2, "prbOverdueamount");
            return (Criteria) this;
        }

        public Criteria andPrbOverdueamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_overDueAmount not between", value1, value2, "prbOverdueamount");
            return (Criteria) this;
        }

        public Criteria andPrbOverduepunishscoreIsNull() {
            addCriterion("prb_overDuePunishScore is null");
            return (Criteria) this;
        }

        public Criteria andPrbOverduepunishscoreIsNotNull() {
            addCriterion("prb_overDuePunishScore is not null");
            return (Criteria) this;
        }

        public Criteria andPrbOverduepunishscoreEqualTo(BigDecimal value) {
            addCriterion("prb_overDuePunishScore =", value, "prbOverduepunishscore");
            return (Criteria) this;
        }

        public Criteria andPrbOverduepunishscoreNotEqualTo(BigDecimal value) {
            addCriterion("prb_overDuePunishScore <>", value, "prbOverduepunishscore");
            return (Criteria) this;
        }

        public Criteria andPrbOverduepunishscoreGreaterThan(BigDecimal value) {
            addCriterion("prb_overDuePunishScore >", value, "prbOverduepunishscore");
            return (Criteria) this;
        }

        public Criteria andPrbOverduepunishscoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_overDuePunishScore >=", value, "prbOverduepunishscore");
            return (Criteria) this;
        }

        public Criteria andPrbOverduepunishscoreLessThan(BigDecimal value) {
            addCriterion("prb_overDuePunishScore <", value, "prbOverduepunishscore");
            return (Criteria) this;
        }

        public Criteria andPrbOverduepunishscoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prb_overDuePunishScore <=", value, "prbOverduepunishscore");
            return (Criteria) this;
        }

        public Criteria andPrbOverduepunishscoreIn(List<BigDecimal> values) {
            addCriterion("prb_overDuePunishScore in", values, "prbOverduepunishscore");
            return (Criteria) this;
        }

        public Criteria andPrbOverduepunishscoreNotIn(List<BigDecimal> values) {
            addCriterion("prb_overDuePunishScore not in", values, "prbOverduepunishscore");
            return (Criteria) this;
        }

        public Criteria andPrbOverduepunishscoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_overDuePunishScore between", value1, value2, "prbOverduepunishscore");
            return (Criteria) this;
        }

        public Criteria andPrbOverduepunishscoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prb_overDuePunishScore not between", value1, value2, "prbOverduepunishscore");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteIsNull() {
            addCriterion("prb_overDueNote is null");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteIsNotNull() {
            addCriterion("prb_overDueNote is not null");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteEqualTo(String value) {
            addCriterion("prb_overDueNote =", value, "prbOverduenote");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteNotEqualTo(String value) {
            addCriterion("prb_overDueNote <>", value, "prbOverduenote");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteGreaterThan(String value) {
            addCriterion("prb_overDueNote >", value, "prbOverduenote");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteGreaterThanOrEqualTo(String value) {
            addCriterion("prb_overDueNote >=", value, "prbOverduenote");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteLessThan(String value) {
            addCriterion("prb_overDueNote <", value, "prbOverduenote");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteLessThanOrEqualTo(String value) {
            addCriterion("prb_overDueNote <=", value, "prbOverduenote");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteLike(String value) {
            addCriterion("prb_overDueNote like", value, "prbOverduenote");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteNotLike(String value) {
            addCriterion("prb_overDueNote not like", value, "prbOverduenote");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteIn(List<String> values) {
            addCriterion("prb_overDueNote in", values, "prbOverduenote");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteNotIn(List<String> values) {
            addCriterion("prb_overDueNote not in", values, "prbOverduenote");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteBetween(String value1, String value2) {
            addCriterion("prb_overDueNote between", value1, value2, "prbOverduenote");
            return (Criteria) this;
        }

        public Criteria andPrbOverduenoteNotBetween(String value1, String value2) {
            addCriterion("prb_overDueNote not between", value1, value2, "prbOverduenote");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentstatusIsNull() {
            addCriterion("prb_repaymentStatus is null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentstatusIsNotNull() {
            addCriterion("prb_repaymentStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentstatusEqualTo(Integer value) {
            addCriterion("prb_repaymentStatus =", value, "prbRepaymentstatus");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentstatusNotEqualTo(Integer value) {
            addCriterion("prb_repaymentStatus <>", value, "prbRepaymentstatus");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentstatusGreaterThan(Integer value) {
            addCriterion("prb_repaymentStatus >", value, "prbRepaymentstatus");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("prb_repaymentStatus >=", value, "prbRepaymentstatus");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentstatusLessThan(Integer value) {
            addCriterion("prb_repaymentStatus <", value, "prbRepaymentstatus");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentstatusLessThanOrEqualTo(Integer value) {
            addCriterion("prb_repaymentStatus <=", value, "prbRepaymentstatus");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentstatusIn(List<Integer> values) {
            addCriterion("prb_repaymentStatus in", values, "prbRepaymentstatus");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentstatusNotIn(List<Integer> values) {
            addCriterion("prb_repaymentStatus not in", values, "prbRepaymentstatus");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentstatusBetween(Integer value1, Integer value2) {
            addCriterion("prb_repaymentStatus between", value1, value2, "prbRepaymentstatus");
            return (Criteria) this;
        }

        public Criteria andPrbRepaymentstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("prb_repaymentStatus not between", value1, value2, "prbRepaymentstatus");
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