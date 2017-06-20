package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_credite_loanExample implements Serializable{
    
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_credite_loanExample() {
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

        public Criteria andPclIdIsNull() {
            addCriterion("pcl_id is null");
            return (Criteria) this;
        }

        public Criteria andPclIdIsNotNull() {
            addCriterion("pcl_id is not null");
            return (Criteria) this;
        }

        public Criteria andPclIdEqualTo(Long value) {
            addCriterion("pcl_id =", value, "pclId");
            return (Criteria) this;
        }

        public Criteria andPclIdNotEqualTo(Long value) {
            addCriterion("pcl_id <>", value, "pclId");
            return (Criteria) this;
        }

        public Criteria andPclIdGreaterThan(Long value) {
            addCriterion("pcl_id >", value, "pclId");
            return (Criteria) this;
        }

        public Criteria andPclIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pcl_id >=", value, "pclId");
            return (Criteria) this;
        }

        public Criteria andPclIdLessThan(Long value) {
            addCriterion("pcl_id <", value, "pclId");
            return (Criteria) this;
        }

        public Criteria andPclIdLessThanOrEqualTo(Long value) {
            addCriterion("pcl_id <=", value, "pclId");
            return (Criteria) this;
        }

        public Criteria andPclIdIn(List<Long> values) {
            addCriterion("pcl_id in", values, "pclId");
            return (Criteria) this;
        }

        public Criteria andPclIdNotIn(List<Long> values) {
            addCriterion("pcl_id not in", values, "pclId");
            return (Criteria) this;
        }

        public Criteria andPclIdBetween(Long value1, Long value2) {
            addCriterion("pcl_id between", value1, value2, "pclId");
            return (Criteria) this;
        }

        public Criteria andPclIdNotBetween(Long value1, Long value2) {
            addCriterion("pcl_id not between", value1, value2, "pclId");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoIsNull() {
            addCriterion("pcl_crediteFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoIsNotNull() {
            addCriterion("pcl_crediteFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoEqualTo(String value) {
            addCriterion("pcl_crediteFlowNo =", value, "pclCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoNotEqualTo(String value) {
            addCriterion("pcl_crediteFlowNo <>", value, "pclCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoGreaterThan(String value) {
            addCriterion("pcl_crediteFlowNo >", value, "pclCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoGreaterThanOrEqualTo(String value) {
            addCriterion("pcl_crediteFlowNo >=", value, "pclCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoLessThan(String value) {
            addCriterion("pcl_crediteFlowNo <", value, "pclCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoLessThanOrEqualTo(String value) {
            addCriterion("pcl_crediteFlowNo <=", value, "pclCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoLike(String value) {
            addCriterion("pcl_crediteFlowNo like", value, "pclCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoNotLike(String value) {
            addCriterion("pcl_crediteFlowNo not like", value, "pclCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoIn(List<String> values) {
            addCriterion("pcl_crediteFlowNo in", values, "pclCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoNotIn(List<String> values) {
            addCriterion("pcl_crediteFlowNo not in", values, "pclCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoBetween(String value1, String value2) {
            addCriterion("pcl_crediteFlowNo between", value1, value2, "pclCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPclCrediteflownoNotBetween(String value1, String value2) {
            addCriterion("pcl_crediteFlowNo not between", value1, value2, "pclCrediteflowno");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumIsNull() {
            addCriterion("pcl_oldFlowNum is null");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumIsNotNull() {
            addCriterion("pcl_oldFlowNum is not null");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumEqualTo(String value) {
            addCriterion("pcl_oldFlowNum =", value, "pclOldflownum");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumNotEqualTo(String value) {
            addCriterion("pcl_oldFlowNum <>", value, "pclOldflownum");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumGreaterThan(String value) {
            addCriterion("pcl_oldFlowNum >", value, "pclOldflownum");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumGreaterThanOrEqualTo(String value) {
            addCriterion("pcl_oldFlowNum >=", value, "pclOldflownum");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumLessThan(String value) {
            addCriterion("pcl_oldFlowNum <", value, "pclOldflownum");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumLessThanOrEqualTo(String value) {
            addCriterion("pcl_oldFlowNum <=", value, "pclOldflownum");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumLike(String value) {
            addCriterion("pcl_oldFlowNum like", value, "pclOldflownum");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumNotLike(String value) {
            addCriterion("pcl_oldFlowNum not like", value, "pclOldflownum");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumIn(List<String> values) {
            addCriterion("pcl_oldFlowNum in", values, "pclOldflownum");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumNotIn(List<String> values) {
            addCriterion("pcl_oldFlowNum not in", values, "pclOldflownum");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumBetween(String value1, String value2) {
            addCriterion("pcl_oldFlowNum between", value1, value2, "pclOldflownum");
            return (Criteria) this;
        }

        public Criteria andPclOldflownumNotBetween(String value1, String value2) {
            addCriterion("pcl_oldFlowNum not between", value1, value2, "pclOldflownum");
            return (Criteria) this;
        }

        public Criteria andPclLoannumIsNull() {
            addCriterion("pcl_loanNum is null");
            return (Criteria) this;
        }

        public Criteria andPclLoannumIsNotNull() {
            addCriterion("pcl_loanNum is not null");
            return (Criteria) this;
        }

        public Criteria andPclLoannumEqualTo(String value) {
            addCriterion("pcl_loanNum =", value, "pclLoannum");
            return (Criteria) this;
        }

        public Criteria andPclLoannumNotEqualTo(String value) {
            addCriterion("pcl_loanNum <>", value, "pclLoannum");
            return (Criteria) this;
        }

        public Criteria andPclLoannumGreaterThan(String value) {
            addCriterion("pcl_loanNum >", value, "pclLoannum");
            return (Criteria) this;
        }

        public Criteria andPclLoannumGreaterThanOrEqualTo(String value) {
            addCriterion("pcl_loanNum >=", value, "pclLoannum");
            return (Criteria) this;
        }

        public Criteria andPclLoannumLessThan(String value) {
            addCriterion("pcl_loanNum <", value, "pclLoannum");
            return (Criteria) this;
        }

        public Criteria andPclLoannumLessThanOrEqualTo(String value) {
            addCriterion("pcl_loanNum <=", value, "pclLoannum");
            return (Criteria) this;
        }

        public Criteria andPclLoannumLike(String value) {
            addCriterion("pcl_loanNum like", value, "pclLoannum");
            return (Criteria) this;
        }

        public Criteria andPclLoannumNotLike(String value) {
            addCriterion("pcl_loanNum not like", value, "pclLoannum");
            return (Criteria) this;
        }

        public Criteria andPclLoannumIn(List<String> values) {
            addCriterion("pcl_loanNum in", values, "pclLoannum");
            return (Criteria) this;
        }

        public Criteria andPclLoannumNotIn(List<String> values) {
            addCriterion("pcl_loanNum not in", values, "pclLoannum");
            return (Criteria) this;
        }

        public Criteria andPclLoannumBetween(String value1, String value2) {
            addCriterion("pcl_loanNum between", value1, value2, "pclLoannum");
            return (Criteria) this;
        }

        public Criteria andPclLoannumNotBetween(String value1, String value2) {
            addCriterion("pcl_loanNum not between", value1, value2, "pclLoannum");
            return (Criteria) this;
        }

        public Criteria andPclCustnoIsNull() {
            addCriterion("pcl_custNo is null");
            return (Criteria) this;
        }

        public Criteria andPclCustnoIsNotNull() {
            addCriterion("pcl_custNo is not null");
            return (Criteria) this;
        }

        public Criteria andPclCustnoEqualTo(String value) {
            addCriterion("pcl_custNo =", value, "pclCustno");
            return (Criteria) this;
        }

        public Criteria andPclCustnoNotEqualTo(String value) {
            addCriterion("pcl_custNo <>", value, "pclCustno");
            return (Criteria) this;
        }

        public Criteria andPclCustnoGreaterThan(String value) {
            addCriterion("pcl_custNo >", value, "pclCustno");
            return (Criteria) this;
        }

        public Criteria andPclCustnoGreaterThanOrEqualTo(String value) {
            addCriterion("pcl_custNo >=", value, "pclCustno");
            return (Criteria) this;
        }

        public Criteria andPclCustnoLessThan(String value) {
            addCriterion("pcl_custNo <", value, "pclCustno");
            return (Criteria) this;
        }

        public Criteria andPclCustnoLessThanOrEqualTo(String value) {
            addCriterion("pcl_custNo <=", value, "pclCustno");
            return (Criteria) this;
        }

        public Criteria andPclCustnoLike(String value) {
            addCriterion("pcl_custNo like", value, "pclCustno");
            return (Criteria) this;
        }

        public Criteria andPclCustnoNotLike(String value) {
            addCriterion("pcl_custNo not like", value, "pclCustno");
            return (Criteria) this;
        }

        public Criteria andPclCustnoIn(List<String> values) {
            addCriterion("pcl_custNo in", values, "pclCustno");
            return (Criteria) this;
        }

        public Criteria andPclCustnoNotIn(List<String> values) {
            addCriterion("pcl_custNo not in", values, "pclCustno");
            return (Criteria) this;
        }

        public Criteria andPclCustnoBetween(String value1, String value2) {
            addCriterion("pcl_custNo between", value1, value2, "pclCustno");
            return (Criteria) this;
        }

        public Criteria andPclCustnoNotBetween(String value1, String value2) {
            addCriterion("pcl_custNo not between", value1, value2, "pclCustno");
            return (Criteria) this;
        }

        public Criteria andPclTransfertimeIsNull() {
            addCriterion("pcl_transferTime is null");
            return (Criteria) this;
        }

        public Criteria andPclTransfertimeIsNotNull() {
            addCriterion("pcl_transferTime is not null");
            return (Criteria) this;
        }

        public Criteria andPclTransfertimeEqualTo(Date value) {
            addCriterion("pcl_transferTime =", value, "pclTransfertime");
            return (Criteria) this;
        }

        public Criteria andPclTransfertimeNotEqualTo(Date value) {
            addCriterion("pcl_transferTime <>", value, "pclTransfertime");
            return (Criteria) this;
        }

        public Criteria andPclTransfertimeGreaterThan(Date value) {
            addCriterion("pcl_transferTime >", value, "pclTransfertime");
            return (Criteria) this;
        }

        public Criteria andPclTransfertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pcl_transferTime >=", value, "pclTransfertime");
            return (Criteria) this;
        }

        public Criteria andPclTransfertimeLessThan(Date value) {
            addCriterion("pcl_transferTime <", value, "pclTransfertime");
            return (Criteria) this;
        }

        public Criteria andPclTransfertimeLessThanOrEqualTo(Date value) {
            addCriterion("pcl_transferTime <=", value, "pclTransfertime");
            return (Criteria) this;
        }

        public Criteria andPclTransfertimeIn(List<Date> values) {
            addCriterion("pcl_transferTime in", values, "pclTransfertime");
            return (Criteria) this;
        }

        public Criteria andPclTransfertimeNotIn(List<Date> values) {
            addCriterion("pcl_transferTime not in", values, "pclTransfertime");
            return (Criteria) this;
        }

        public Criteria andPclTransfertimeBetween(Date value1, Date value2) {
            addCriterion("pcl_transferTime between", value1, value2, "pclTransfertime");
            return (Criteria) this;
        }

        public Criteria andPclTransfertimeNotBetween(Date value1, Date value2) {
            addCriterion("pcl_transferTime not between", value1, value2, "pclTransfertime");
            return (Criteria) this;
        }

        public Criteria andPclTenderdatetimeIsNull() {
            addCriterion("pcl_tenderdatetime is null");
            return (Criteria) this;
        }

        public Criteria andPclTenderdatetimeIsNotNull() {
            addCriterion("pcl_tenderdatetime is not null");
            return (Criteria) this;
        }

        public Criteria andPclTenderdatetimeEqualTo(Integer value) {
            addCriterion("pcl_tenderdatetime =", value, "pclTenderdatetime");
            return (Criteria) this;
        }

        public Criteria andPclTenderdatetimeNotEqualTo(Integer value) {
            addCriterion("pcl_tenderdatetime <>", value, "pclTenderdatetime");
            return (Criteria) this;
        }

        public Criteria andPclTenderdatetimeGreaterThan(Integer value) {
            addCriterion("pcl_tenderdatetime >", value, "pclTenderdatetime");
            return (Criteria) this;
        }

        public Criteria andPclTenderdatetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pcl_tenderdatetime >=", value, "pclTenderdatetime");
            return (Criteria) this;
        }

        public Criteria andPclTenderdatetimeLessThan(Integer value) {
            addCriterion("pcl_tenderdatetime <", value, "pclTenderdatetime");
            return (Criteria) this;
        }

        public Criteria andPclTenderdatetimeLessThanOrEqualTo(Integer value) {
            addCriterion("pcl_tenderdatetime <=", value, "pclTenderdatetime");
            return (Criteria) this;
        }

        public Criteria andPclTenderdatetimeIn(List<Integer> values) {
            addCriterion("pcl_tenderdatetime in", values, "pclTenderdatetime");
            return (Criteria) this;
        }

        public Criteria andPclTenderdatetimeNotIn(List<Integer> values) {
            addCriterion("pcl_tenderdatetime not in", values, "pclTenderdatetime");
            return (Criteria) this;
        }

        public Criteria andPclTenderdatetimeBetween(Integer value1, Integer value2) {
            addCriterion("pcl_tenderdatetime between", value1, value2, "pclTenderdatetime");
            return (Criteria) this;
        }

        public Criteria andPclTenderdatetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("pcl_tenderdatetime not between", value1, value2, "pclTenderdatetime");
            return (Criteria) this;
        }

        public Criteria andPclCrediterateIsNull() {
            addCriterion("pcl_crediteRate is null");
            return (Criteria) this;
        }

        public Criteria andPclCrediterateIsNotNull() {
            addCriterion("pcl_crediteRate is not null");
            return (Criteria) this;
        }

        public Criteria andPclCrediterateEqualTo(BigDecimal value) {
            addCriterion("pcl_crediteRate =", value, "pclCrediterate");
            return (Criteria) this;
        }

        public Criteria andPclCrediterateNotEqualTo(BigDecimal value) {
            addCriterion("pcl_crediteRate <>", value, "pclCrediterate");
            return (Criteria) this;
        }

        public Criteria andPclCrediterateGreaterThan(BigDecimal value) {
            addCriterion("pcl_crediteRate >", value, "pclCrediterate");
            return (Criteria) this;
        }

        public Criteria andPclCrediterateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pcl_crediteRate >=", value, "pclCrediterate");
            return (Criteria) this;
        }

        public Criteria andPclCrediterateLessThan(BigDecimal value) {
            addCriterion("pcl_crediteRate <", value, "pclCrediterate");
            return (Criteria) this;
        }

        public Criteria andPclCrediterateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pcl_crediteRate <=", value, "pclCrediterate");
            return (Criteria) this;
        }

        public Criteria andPclCrediterateIn(List<BigDecimal> values) {
            addCriterion("pcl_crediteRate in", values, "pclCrediterate");
            return (Criteria) this;
        }

        public Criteria andPclCrediterateNotIn(List<BigDecimal> values) {
            addCriterion("pcl_crediteRate not in", values, "pclCrediterate");
            return (Criteria) this;
        }

        public Criteria andPclCrediterateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcl_crediteRate between", value1, value2, "pclCrediterate");
            return (Criteria) this;
        }

        public Criteria andPclCrediterateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcl_crediteRate not between", value1, value2, "pclCrediterate");
            return (Criteria) this;
        }

        public Criteria andPclCrediteamtIsNull() {
            addCriterion("pcl_crediteAmt is null");
            return (Criteria) this;
        }

        public Criteria andPclCrediteamtIsNotNull() {
            addCriterion("pcl_crediteAmt is not null");
            return (Criteria) this;
        }

        public Criteria andPclCrediteamtEqualTo(BigDecimal value) {
            addCriterion("pcl_crediteAmt =", value, "pclCrediteamt");
            return (Criteria) this;
        }

        public Criteria andPclCrediteamtNotEqualTo(BigDecimal value) {
            addCriterion("pcl_crediteAmt <>", value, "pclCrediteamt");
            return (Criteria) this;
        }

        public Criteria andPclCrediteamtGreaterThan(BigDecimal value) {
            addCriterion("pcl_crediteAmt >", value, "pclCrediteamt");
            return (Criteria) this;
        }

        public Criteria andPclCrediteamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pcl_crediteAmt >=", value, "pclCrediteamt");
            return (Criteria) this;
        }

        public Criteria andPclCrediteamtLessThan(BigDecimal value) {
            addCriterion("pcl_crediteAmt <", value, "pclCrediteamt");
            return (Criteria) this;
        }

        public Criteria andPclCrediteamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pcl_crediteAmt <=", value, "pclCrediteamt");
            return (Criteria) this;
        }

        public Criteria andPclCrediteamtIn(List<BigDecimal> values) {
            addCriterion("pcl_crediteAmt in", values, "pclCrediteamt");
            return (Criteria) this;
        }

        public Criteria andPclCrediteamtNotIn(List<BigDecimal> values) {
            addCriterion("pcl_crediteAmt not in", values, "pclCrediteamt");
            return (Criteria) this;
        }

        public Criteria andPclCrediteamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcl_crediteAmt between", value1, value2, "pclCrediteamt");
            return (Criteria) this;
        }

        public Criteria andPclCrediteamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcl_crediteAmt not between", value1, value2, "pclCrediteamt");
            return (Criteria) this;
        }

        public Criteria andPclTransferamtIsNull() {
            addCriterion("pcl_transferAmt is null");
            return (Criteria) this;
        }

        public Criteria andPclTransferamtIsNotNull() {
            addCriterion("pcl_transferAmt is not null");
            return (Criteria) this;
        }

        public Criteria andPclTransferamtEqualTo(BigDecimal value) {
            addCriterion("pcl_transferAmt =", value, "pclTransferamt");
            return (Criteria) this;
        }

        public Criteria andPclTransferamtNotEqualTo(BigDecimal value) {
            addCriterion("pcl_transferAmt <>", value, "pclTransferamt");
            return (Criteria) this;
        }

        public Criteria andPclTransferamtGreaterThan(BigDecimal value) {
            addCriterion("pcl_transferAmt >", value, "pclTransferamt");
            return (Criteria) this;
        }

        public Criteria andPclTransferamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pcl_transferAmt >=", value, "pclTransferamt");
            return (Criteria) this;
        }

        public Criteria andPclTransferamtLessThan(BigDecimal value) {
            addCriterion("pcl_transferAmt <", value, "pclTransferamt");
            return (Criteria) this;
        }

        public Criteria andPclTransferamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pcl_transferAmt <=", value, "pclTransferamt");
            return (Criteria) this;
        }

        public Criteria andPclTransferamtIn(List<BigDecimal> values) {
            addCriterion("pcl_transferAmt in", values, "pclTransferamt");
            return (Criteria) this;
        }

        public Criteria andPclTransferamtNotIn(List<BigDecimal> values) {
            addCriterion("pcl_transferAmt not in", values, "pclTransferamt");
            return (Criteria) this;
        }

        public Criteria andPclTransferamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcl_transferAmt between", value1, value2, "pclTransferamt");
            return (Criteria) this;
        }

        public Criteria andPclTransferamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pcl_transferAmt not between", value1, value2, "pclTransferamt");
            return (Criteria) this;
        }

        public Criteria andPclCrediteperiodsIsNull() {
            addCriterion("pcl_creditePeriods is null");
            return (Criteria) this;
        }

        public Criteria andPclCrediteperiodsIsNotNull() {
            addCriterion("pcl_creditePeriods is not null");
            return (Criteria) this;
        }

        public Criteria andPclCrediteperiodsEqualTo(Integer value) {
            addCriterion("pcl_creditePeriods =", value, "pclCrediteperiods");
            return (Criteria) this;
        }

        public Criteria andPclCrediteperiodsNotEqualTo(Integer value) {
            addCriterion("pcl_creditePeriods <>", value, "pclCrediteperiods");
            return (Criteria) this;
        }

        public Criteria andPclCrediteperiodsGreaterThan(Integer value) {
            addCriterion("pcl_creditePeriods >", value, "pclCrediteperiods");
            return (Criteria) this;
        }

        public Criteria andPclCrediteperiodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("pcl_creditePeriods >=", value, "pclCrediteperiods");
            return (Criteria) this;
        }

        public Criteria andPclCrediteperiodsLessThan(Integer value) {
            addCriterion("pcl_creditePeriods <", value, "pclCrediteperiods");
            return (Criteria) this;
        }

        public Criteria andPclCrediteperiodsLessThanOrEqualTo(Integer value) {
            addCriterion("pcl_creditePeriods <=", value, "pclCrediteperiods");
            return (Criteria) this;
        }

        public Criteria andPclCrediteperiodsIn(List<Integer> values) {
            addCriterion("pcl_creditePeriods in", values, "pclCrediteperiods");
            return (Criteria) this;
        }

        public Criteria andPclCrediteperiodsNotIn(List<Integer> values) {
            addCriterion("pcl_creditePeriods not in", values, "pclCrediteperiods");
            return (Criteria) this;
        }

        public Criteria andPclCrediteperiodsBetween(Integer value1, Integer value2) {
            addCriterion("pcl_creditePeriods between", value1, value2, "pclCrediteperiods");
            return (Criteria) this;
        }

        public Criteria andPclCrediteperiodsNotBetween(Integer value1, Integer value2) {
            addCriterion("pcl_creditePeriods not between", value1, value2, "pclCrediteperiods");
            return (Criteria) this;
        }

        public Criteria andPclChannelIsNull() {
            addCriterion("pcl_channel is null");
            return (Criteria) this;
        }

        public Criteria andPclChannelIsNotNull() {
            addCriterion("pcl_channel is not null");
            return (Criteria) this;
        }

        public Criteria andPclChannelEqualTo(String value) {
            addCriterion("pcl_channel =", value, "pclChannel");
            return (Criteria) this;
        }

        public Criteria andPclChannelNotEqualTo(String value) {
            addCriterion("pcl_channel <>", value, "pclChannel");
            return (Criteria) this;
        }

        public Criteria andPclChannelGreaterThan(String value) {
            addCriterion("pcl_channel >", value, "pclChannel");
            return (Criteria) this;
        }

        public Criteria andPclChannelGreaterThanOrEqualTo(String value) {
            addCriterion("pcl_channel >=", value, "pclChannel");
            return (Criteria) this;
        }

        public Criteria andPclChannelLessThan(String value) {
            addCriterion("pcl_channel <", value, "pclChannel");
            return (Criteria) this;
        }

        public Criteria andPclChannelLessThanOrEqualTo(String value) {
            addCriterion("pcl_channel <=", value, "pclChannel");
            return (Criteria) this;
        }

        public Criteria andPclChannelLike(String value) {
            addCriterion("pcl_channel like", value, "pclChannel");
            return (Criteria) this;
        }

        public Criteria andPclChannelNotLike(String value) {
            addCriterion("pcl_channel not like", value, "pclChannel");
            return (Criteria) this;
        }

        public Criteria andPclChannelIn(List<String> values) {
            addCriterion("pcl_channel in", values, "pclChannel");
            return (Criteria) this;
        }

        public Criteria andPclChannelNotIn(List<String> values) {
            addCriterion("pcl_channel not in", values, "pclChannel");
            return (Criteria) this;
        }

        public Criteria andPclChannelBetween(String value1, String value2) {
            addCriterion("pcl_channel between", value1, value2, "pclChannel");
            return (Criteria) this;
        }

        public Criteria andPclChannelNotBetween(String value1, String value2) {
            addCriterion("pcl_channel not between", value1, value2, "pclChannel");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusIsNull() {
            addCriterion("pcl_crediteStatus is null");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusIsNotNull() {
            addCriterion("pcl_crediteStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusEqualTo(String value) {
            addCriterion("pcl_crediteStatus =", value, "pclCreditestatus");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusNotEqualTo(String value) {
            addCriterion("pcl_crediteStatus <>", value, "pclCreditestatus");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusGreaterThan(String value) {
            addCriterion("pcl_crediteStatus >", value, "pclCreditestatus");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusGreaterThanOrEqualTo(String value) {
            addCriterion("pcl_crediteStatus >=", value, "pclCreditestatus");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusLessThan(String value) {
            addCriterion("pcl_crediteStatus <", value, "pclCreditestatus");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusLessThanOrEqualTo(String value) {
            addCriterion("pcl_crediteStatus <=", value, "pclCreditestatus");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusLike(String value) {
            addCriterion("pcl_crediteStatus like", value, "pclCreditestatus");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusNotLike(String value) {
            addCriterion("pcl_crediteStatus not like", value, "pclCreditestatus");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusIn(List<String> values) {
            addCriterion("pcl_crediteStatus in", values, "pclCreditestatus");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusNotIn(List<String> values) {
            addCriterion("pcl_crediteStatus not in", values, "pclCreditestatus");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusBetween(String value1, String value2) {
            addCriterion("pcl_crediteStatus between", value1, value2, "pclCreditestatus");
            return (Criteria) this;
        }

        public Criteria andPclCreditestatusNotBetween(String value1, String value2) {
            addCriterion("pcl_crediteStatus not between", value1, value2, "pclCreditestatus");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionIsNull() {
            addCriterion("pcl_description is null");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionIsNotNull() {
            addCriterion("pcl_description is not null");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionEqualTo(String value) {
            addCriterion("pcl_description =", value, "pclDescription");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionNotEqualTo(String value) {
            addCriterion("pcl_description <>", value, "pclDescription");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionGreaterThan(String value) {
            addCriterion("pcl_description >", value, "pclDescription");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("pcl_description >=", value, "pclDescription");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionLessThan(String value) {
            addCriterion("pcl_description <", value, "pclDescription");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionLessThanOrEqualTo(String value) {
            addCriterion("pcl_description <=", value, "pclDescription");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionLike(String value) {
            addCriterion("pcl_description like", value, "pclDescription");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionNotLike(String value) {
            addCriterion("pcl_description not like", value, "pclDescription");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionIn(List<String> values) {
            addCriterion("pcl_description in", values, "pclDescription");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionNotIn(List<String> values) {
            addCriterion("pcl_description not in", values, "pclDescription");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionBetween(String value1, String value2) {
            addCriterion("pcl_description between", value1, value2, "pclDescription");
            return (Criteria) this;
        }

        public Criteria andPclDescriptionNotBetween(String value1, String value2) {
            addCriterion("pcl_description not between", value1, value2, "pclDescription");
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