package com.baibao.web.p2p.generator.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_tender_recordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_tender_recordExample() {
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

        public Criteria andPtrTenderflownoIsNull() {
            addCriterion("ptr_tenderFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoIsNotNull() {
            addCriterion("ptr_tenderFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoEqualTo(String value) {
            addCriterion("ptr_tenderFlowNo =", value, "ptrTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoNotEqualTo(String value) {
            addCriterion("ptr_tenderFlowNo <>", value, "ptrTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoGreaterThan(String value) {
            addCriterion("ptr_tenderFlowNo >", value, "ptrTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_tenderFlowNo >=", value, "ptrTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoLessThan(String value) {
            addCriterion("ptr_tenderFlowNo <", value, "ptrTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoLessThanOrEqualTo(String value) {
            addCriterion("ptr_tenderFlowNo <=", value, "ptrTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoLike(String value) {
            addCriterion("ptr_tenderFlowNo like", value, "ptrTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoNotLike(String value) {
            addCriterion("ptr_tenderFlowNo not like", value, "ptrTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoIn(List<String> values) {
            addCriterion("ptr_tenderFlowNo in", values, "ptrTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoNotIn(List<String> values) {
            addCriterion("ptr_tenderFlowNo not in", values, "ptrTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoBetween(String value1, String value2) {
            addCriterion("ptr_tenderFlowNo between", value1, value2, "ptrTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtrTenderflownoNotBetween(String value1, String value2) {
            addCriterion("ptr_tenderFlowNo not between", value1, value2, "ptrTenderflowno");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoIsNull() {
            addCriterion("ptr_accountNo is null");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoIsNotNull() {
            addCriterion("ptr_accountNo is not null");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoEqualTo(String value) {
            addCriterion("ptr_accountNo =", value, "ptrAccountno");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoNotEqualTo(String value) {
            addCriterion("ptr_accountNo <>", value, "ptrAccountno");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoGreaterThan(String value) {
            addCriterion("ptr_accountNo >", value, "ptrAccountno");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_accountNo >=", value, "ptrAccountno");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoLessThan(String value) {
            addCriterion("ptr_accountNo <", value, "ptrAccountno");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoLessThanOrEqualTo(String value) {
            addCriterion("ptr_accountNo <=", value, "ptrAccountno");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoLike(String value) {
            addCriterion("ptr_accountNo like", value, "ptrAccountno");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoNotLike(String value) {
            addCriterion("ptr_accountNo not like", value, "ptrAccountno");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoIn(List<String> values) {
            addCriterion("ptr_accountNo in", values, "ptrAccountno");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoNotIn(List<String> values) {
            addCriterion("ptr_accountNo not in", values, "ptrAccountno");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoBetween(String value1, String value2) {
            addCriterion("ptr_accountNo between", value1, value2, "ptrAccountno");
            return (Criteria) this;
        }

        public Criteria andPtrAccountnoNotBetween(String value1, String value2) {
            addCriterion("ptr_accountNo not between", value1, value2, "ptrAccountno");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoIsNull() {
            addCriterion("ptr_productNo is null");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoIsNotNull() {
            addCriterion("ptr_productNo is not null");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoEqualTo(String value) {
            addCriterion("ptr_productNo =", value, "ptrProductno");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoNotEqualTo(String value) {
            addCriterion("ptr_productNo <>", value, "ptrProductno");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoGreaterThan(String value) {
            addCriterion("ptr_productNo >", value, "ptrProductno");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_productNo >=", value, "ptrProductno");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoLessThan(String value) {
            addCriterion("ptr_productNo <", value, "ptrProductno");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoLessThanOrEqualTo(String value) {
            addCriterion("ptr_productNo <=", value, "ptrProductno");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoLike(String value) {
            addCriterion("ptr_productNo like", value, "ptrProductno");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoNotLike(String value) {
            addCriterion("ptr_productNo not like", value, "ptrProductno");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoIn(List<String> values) {
            addCriterion("ptr_productNo in", values, "ptrProductno");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoNotIn(List<String> values) {
            addCriterion("ptr_productNo not in", values, "ptrProductno");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoBetween(String value1, String value2) {
            addCriterion("ptr_productNo between", value1, value2, "ptrProductno");
            return (Criteria) this;
        }

        public Criteria andPtrProductnoNotBetween(String value1, String value2) {
            addCriterion("ptr_productNo not between", value1, value2, "ptrProductno");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoIsNull() {
            addCriterion("ptr_custNo is null");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoIsNotNull() {
            addCriterion("ptr_custNo is not null");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoEqualTo(String value) {
            addCriterion("ptr_custNo =", value, "ptrCustno");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoNotEqualTo(String value) {
            addCriterion("ptr_custNo <>", value, "ptrCustno");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoGreaterThan(String value) {
            addCriterion("ptr_custNo >", value, "ptrCustno");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_custNo >=", value, "ptrCustno");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoLessThan(String value) {
            addCriterion("ptr_custNo <", value, "ptrCustno");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoLessThanOrEqualTo(String value) {
            addCriterion("ptr_custNo <=", value, "ptrCustno");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoLike(String value) {
            addCriterion("ptr_custNo like", value, "ptrCustno");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoNotLike(String value) {
            addCriterion("ptr_custNo not like", value, "ptrCustno");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoIn(List<String> values) {
            addCriterion("ptr_custNo in", values, "ptrCustno");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoNotIn(List<String> values) {
            addCriterion("ptr_custNo not in", values, "ptrCustno");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoBetween(String value1, String value2) {
            addCriterion("ptr_custNo between", value1, value2, "ptrCustno");
            return (Criteria) this;
        }

        public Criteria andPtrCustnoNotBetween(String value1, String value2) {
            addCriterion("ptr_custNo not between", value1, value2, "ptrCustno");
            return (Criteria) this;
        }

        public Criteria andPtrAmountIsNull() {
            addCriterion("ptr_amount is null");
            return (Criteria) this;
        }

        public Criteria andPtrAmountIsNotNull() {
            addCriterion("ptr_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPtrAmountEqualTo(BigDecimal value) {
            addCriterion("ptr_amount =", value, "ptrAmount");
            return (Criteria) this;
        }

        public Criteria andPtrAmountNotEqualTo(BigDecimal value) {
            addCriterion("ptr_amount <>", value, "ptrAmount");
            return (Criteria) this;
        }

        public Criteria andPtrAmountGreaterThan(BigDecimal value) {
            addCriterion("ptr_amount >", value, "ptrAmount");
            return (Criteria) this;
        }

        public Criteria andPtrAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ptr_amount >=", value, "ptrAmount");
            return (Criteria) this;
        }

        public Criteria andPtrAmountLessThan(BigDecimal value) {
            addCriterion("ptr_amount <", value, "ptrAmount");
            return (Criteria) this;
        }

        public Criteria andPtrAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ptr_amount <=", value, "ptrAmount");
            return (Criteria) this;
        }

        public Criteria andPtrAmountIn(List<BigDecimal> values) {
            addCriterion("ptr_amount in", values, "ptrAmount");
            return (Criteria) this;
        }

        public Criteria andPtrAmountNotIn(List<BigDecimal> values) {
            addCriterion("ptr_amount not in", values, "ptrAmount");
            return (Criteria) this;
        }

        public Criteria andPtrAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptr_amount between", value1, value2, "ptrAmount");
            return (Criteria) this;
        }

        public Criteria andPtrAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ptr_amount not between", value1, value2, "ptrAmount");
            return (Criteria) this;
        }

        public Criteria andPtrTranstimeIsNull() {
            addCriterion("ptr_transTime is null");
            return (Criteria) this;
        }

        public Criteria andPtrTranstimeIsNotNull() {
            addCriterion("ptr_transTime is not null");
            return (Criteria) this;
        }

        public Criteria andPtrTranstimeEqualTo(Date value) {
            addCriterion("ptr_transTime =", value, "ptrTranstime");
            return (Criteria) this;
        }

        public Criteria andPtrTranstimeNotEqualTo(Date value) {
            addCriterion("ptr_transTime <>", value, "ptrTranstime");
            return (Criteria) this;
        }

        public Criteria andPtrTranstimeGreaterThan(Date value) {
            addCriterion("ptr_transTime >", value, "ptrTranstime");
            return (Criteria) this;
        }

        public Criteria andPtrTranstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ptr_transTime >=", value, "ptrTranstime");
            return (Criteria) this;
        }

        public Criteria andPtrTranstimeLessThan(Date value) {
            addCriterion("ptr_transTime <", value, "ptrTranstime");
            return (Criteria) this;
        }

        public Criteria andPtrTranstimeLessThanOrEqualTo(Date value) {
            addCriterion("ptr_transTime <=", value, "ptrTranstime");
            return (Criteria) this;
        }

        public Criteria andPtrTranstimeIn(List<Date> values) {
            addCriterion("ptr_transTime in", values, "ptrTranstime");
            return (Criteria) this;
        }

        public Criteria andPtrTranstimeNotIn(List<Date> values) {
            addCriterion("ptr_transTime not in", values, "ptrTranstime");
            return (Criteria) this;
        }

        public Criteria andPtrTranstimeBetween(Date value1, Date value2) {
            addCriterion("ptr_transTime between", value1, value2, "ptrTranstime");
            return (Criteria) this;
        }

        public Criteria andPtrTranstimeNotBetween(Date value1, Date value2) {
            addCriterion("ptr_transTime not between", value1, value2, "ptrTranstime");
            return (Criteria) this;
        }

        public Criteria andPtrStatusIsNull() {
            addCriterion("ptr_status is null");
            return (Criteria) this;
        }

        public Criteria andPtrStatusIsNotNull() {
            addCriterion("ptr_status is not null");
            return (Criteria) this;
        }

        public Criteria andPtrStatusEqualTo(String value) {
            addCriterion("ptr_status =", value, "ptrStatus");
            return (Criteria) this;
        }

        public Criteria andPtrStatusNotEqualTo(String value) {
            addCriterion("ptr_status <>", value, "ptrStatus");
            return (Criteria) this;
        }

        public Criteria andPtrStatusGreaterThan(String value) {
            addCriterion("ptr_status >", value, "ptrStatus");
            return (Criteria) this;
        }

        public Criteria andPtrStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_status >=", value, "ptrStatus");
            return (Criteria) this;
        }

        public Criteria andPtrStatusLessThan(String value) {
            addCriterion("ptr_status <", value, "ptrStatus");
            return (Criteria) this;
        }

        public Criteria andPtrStatusLessThanOrEqualTo(String value) {
            addCriterion("ptr_status <=", value, "ptrStatus");
            return (Criteria) this;
        }

        public Criteria andPtrStatusLike(String value) {
            addCriterion("ptr_status like", value, "ptrStatus");
            return (Criteria) this;
        }

        public Criteria andPtrStatusNotLike(String value) {
            addCriterion("ptr_status not like", value, "ptrStatus");
            return (Criteria) this;
        }

        public Criteria andPtrStatusIn(List<String> values) {
            addCriterion("ptr_status in", values, "ptrStatus");
            return (Criteria) this;
        }

        public Criteria andPtrStatusNotIn(List<String> values) {
            addCriterion("ptr_status not in", values, "ptrStatus");
            return (Criteria) this;
        }

        public Criteria andPtrStatusBetween(String value1, String value2) {
            addCriterion("ptr_status between", value1, value2, "ptrStatus");
            return (Criteria) this;
        }

        public Criteria andPtrStatusNotBetween(String value1, String value2) {
            addCriterion("ptr_status not between", value1, value2, "ptrStatus");
            return (Criteria) this;
        }

        public Criteria andPtrChannelIsNull() {
            addCriterion("ptr_channel is null");
            return (Criteria) this;
        }

        public Criteria andPtrChannelIsNotNull() {
            addCriterion("ptr_channel is not null");
            return (Criteria) this;
        }

        public Criteria andPtrChannelEqualTo(String value) {
            addCriterion("ptr_channel =", value, "ptrChannel");
            return (Criteria) this;
        }

        public Criteria andPtrChannelNotEqualTo(String value) {
            addCriterion("ptr_channel <>", value, "ptrChannel");
            return (Criteria) this;
        }

        public Criteria andPtrChannelGreaterThan(String value) {
            addCriterion("ptr_channel >", value, "ptrChannel");
            return (Criteria) this;
        }

        public Criteria andPtrChannelGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_channel >=", value, "ptrChannel");
            return (Criteria) this;
        }

        public Criteria andPtrChannelLessThan(String value) {
            addCriterion("ptr_channel <", value, "ptrChannel");
            return (Criteria) this;
        }

        public Criteria andPtrChannelLessThanOrEqualTo(String value) {
            addCriterion("ptr_channel <=", value, "ptrChannel");
            return (Criteria) this;
        }

        public Criteria andPtrChannelLike(String value) {
            addCriterion("ptr_channel like", value, "ptrChannel");
            return (Criteria) this;
        }

        public Criteria andPtrChannelNotLike(String value) {
            addCriterion("ptr_channel not like", value, "ptrChannel");
            return (Criteria) this;
        }

        public Criteria andPtrChannelIn(List<String> values) {
            addCriterion("ptr_channel in", values, "ptrChannel");
            return (Criteria) this;
        }

        public Criteria andPtrChannelNotIn(List<String> values) {
            addCriterion("ptr_channel not in", values, "ptrChannel");
            return (Criteria) this;
        }

        public Criteria andPtrChannelBetween(String value1, String value2) {
            addCriterion("ptr_channel between", value1, value2, "ptrChannel");
            return (Criteria) this;
        }

        public Criteria andPtrChannelNotBetween(String value1, String value2) {
            addCriterion("ptr_channel not between", value1, value2, "ptrChannel");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusIsNull() {
            addCriterion("ptr_tradeStatus is null");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusIsNotNull() {
            addCriterion("ptr_tradeStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusEqualTo(String value) {
            addCriterion("ptr_tradeStatus =", value, "ptrTradestatus");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusNotEqualTo(String value) {
            addCriterion("ptr_tradeStatus <>", value, "ptrTradestatus");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusGreaterThan(String value) {
            addCriterion("ptr_tradeStatus >", value, "ptrTradestatus");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_tradeStatus >=", value, "ptrTradestatus");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusLessThan(String value) {
            addCriterion("ptr_tradeStatus <", value, "ptrTradestatus");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusLessThanOrEqualTo(String value) {
            addCriterion("ptr_tradeStatus <=", value, "ptrTradestatus");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusLike(String value) {
            addCriterion("ptr_tradeStatus like", value, "ptrTradestatus");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusNotLike(String value) {
            addCriterion("ptr_tradeStatus not like", value, "ptrTradestatus");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusIn(List<String> values) {
            addCriterion("ptr_tradeStatus in", values, "ptrTradestatus");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusNotIn(List<String> values) {
            addCriterion("ptr_tradeStatus not in", values, "ptrTradestatus");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusBetween(String value1, String value2) {
            addCriterion("ptr_tradeStatus between", value1, value2, "ptrTradestatus");
            return (Criteria) this;
        }

        public Criteria andPtrTradestatusNotBetween(String value1, String value2) {
            addCriterion("ptr_tradeStatus not between", value1, value2, "ptrTradestatus");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeIsNull() {
            addCriterion("ptr_payStatusCode is null");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeIsNotNull() {
            addCriterion("ptr_payStatusCode is not null");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeEqualTo(String value) {
            addCriterion("ptr_payStatusCode =", value, "ptrPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeNotEqualTo(String value) {
            addCriterion("ptr_payStatusCode <>", value, "ptrPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeGreaterThan(String value) {
            addCriterion("ptr_payStatusCode >", value, "ptrPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_payStatusCode >=", value, "ptrPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeLessThan(String value) {
            addCriterion("ptr_payStatusCode <", value, "ptrPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeLessThanOrEqualTo(String value) {
            addCriterion("ptr_payStatusCode <=", value, "ptrPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeLike(String value) {
            addCriterion("ptr_payStatusCode like", value, "ptrPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeNotLike(String value) {
            addCriterion("ptr_payStatusCode not like", value, "ptrPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeIn(List<String> values) {
            addCriterion("ptr_payStatusCode in", values, "ptrPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeNotIn(List<String> values) {
            addCriterion("ptr_payStatusCode not in", values, "ptrPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeBetween(String value1, String value2) {
            addCriterion("ptr_payStatusCode between", value1, value2, "ptrPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPtrPaystatuscodeNotBetween(String value1, String value2) {
            addCriterion("ptr_payStatusCode not between", value1, value2, "ptrPaystatuscode");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseTimeIsNull() {
            addCriterion("ptr_host_response_time is null");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseTimeIsNotNull() {
            addCriterion("ptr_host_response_time is not null");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseTimeEqualTo(Date value) {
            addCriterion("ptr_host_response_time =", value, "ptrHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseTimeNotEqualTo(Date value) {
            addCriterion("ptr_host_response_time <>", value, "ptrHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseTimeGreaterThan(Date value) {
            addCriterion("ptr_host_response_time >", value, "ptrHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ptr_host_response_time >=", value, "ptrHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseTimeLessThan(Date value) {
            addCriterion("ptr_host_response_time <", value, "ptrHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseTimeLessThanOrEqualTo(Date value) {
            addCriterion("ptr_host_response_time <=", value, "ptrHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseTimeIn(List<Date> values) {
            addCriterion("ptr_host_response_time in", values, "ptrHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseTimeNotIn(List<Date> values) {
            addCriterion("ptr_host_response_time not in", values, "ptrHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseTimeBetween(Date value1, Date value2) {
            addCriterion("ptr_host_response_time between", value1, value2, "ptrHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseTimeNotBetween(Date value1, Date value2) {
            addCriterion("ptr_host_response_time not between", value1, value2, "ptrHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoIsNull() {
            addCriterion("ptr_host_response_flowNo is null");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoIsNotNull() {
            addCriterion("ptr_host_response_flowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoEqualTo(String value) {
            addCriterion("ptr_host_response_flowNo =", value, "ptrHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoNotEqualTo(String value) {
            addCriterion("ptr_host_response_flowNo <>", value, "ptrHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoGreaterThan(String value) {
            addCriterion("ptr_host_response_flowNo >", value, "ptrHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_host_response_flowNo >=", value, "ptrHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoLessThan(String value) {
            addCriterion("ptr_host_response_flowNo <", value, "ptrHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoLessThanOrEqualTo(String value) {
            addCriterion("ptr_host_response_flowNo <=", value, "ptrHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoLike(String value) {
            addCriterion("ptr_host_response_flowNo like", value, "ptrHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoNotLike(String value) {
            addCriterion("ptr_host_response_flowNo not like", value, "ptrHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoIn(List<String> values) {
            addCriterion("ptr_host_response_flowNo in", values, "ptrHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoNotIn(List<String> values) {
            addCriterion("ptr_host_response_flowNo not in", values, "ptrHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoBetween(String value1, String value2) {
            addCriterion("ptr_host_response_flowNo between", value1, value2, "ptrHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPtrHostResponseFlownoNotBetween(String value1, String value2) {
            addCriterion("ptr_host_response_flowNo not between", value1, value2, "ptrHostResponseFlowno");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeIsNull() {
            addCriterion("ptr_host_return_code is null");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeIsNotNull() {
            addCriterion("ptr_host_return_code is not null");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeEqualTo(String value) {
            addCriterion("ptr_host_return_code =", value, "ptrHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeNotEqualTo(String value) {
            addCriterion("ptr_host_return_code <>", value, "ptrHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeGreaterThan(String value) {
            addCriterion("ptr_host_return_code >", value, "ptrHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_host_return_code >=", value, "ptrHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeLessThan(String value) {
            addCriterion("ptr_host_return_code <", value, "ptrHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeLessThanOrEqualTo(String value) {
            addCriterion("ptr_host_return_code <=", value, "ptrHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeLike(String value) {
            addCriterion("ptr_host_return_code like", value, "ptrHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeNotLike(String value) {
            addCriterion("ptr_host_return_code not like", value, "ptrHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeIn(List<String> values) {
            addCriterion("ptr_host_return_code in", values, "ptrHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeNotIn(List<String> values) {
            addCriterion("ptr_host_return_code not in", values, "ptrHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeBetween(String value1, String value2) {
            addCriterion("ptr_host_return_code between", value1, value2, "ptrHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnCodeNotBetween(String value1, String value2) {
            addCriterion("ptr_host_return_code not between", value1, value2, "ptrHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageIsNull() {
            addCriterion("ptr_host_return_message is null");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageIsNotNull() {
            addCriterion("ptr_host_return_message is not null");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageEqualTo(String value) {
            addCriterion("ptr_host_return_message =", value, "ptrHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageNotEqualTo(String value) {
            addCriterion("ptr_host_return_message <>", value, "ptrHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageGreaterThan(String value) {
            addCriterion("ptr_host_return_message >", value, "ptrHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_host_return_message >=", value, "ptrHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageLessThan(String value) {
            addCriterion("ptr_host_return_message <", value, "ptrHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageLessThanOrEqualTo(String value) {
            addCriterion("ptr_host_return_message <=", value, "ptrHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageLike(String value) {
            addCriterion("ptr_host_return_message like", value, "ptrHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageNotLike(String value) {
            addCriterion("ptr_host_return_message not like", value, "ptrHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageIn(List<String> values) {
            addCriterion("ptr_host_return_message in", values, "ptrHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageNotIn(List<String> values) {
            addCriterion("ptr_host_return_message not in", values, "ptrHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageBetween(String value1, String value2) {
            addCriterion("ptr_host_return_message between", value1, value2, "ptrHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtrHostReturnMessageNotBetween(String value1, String value2) {
            addCriterion("ptr_host_return_message not between", value1, value2, "ptrHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusIsNull() {
            addCriterion("ptr_dealStatus is null");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusIsNotNull() {
            addCriterion("ptr_dealStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusEqualTo(String value) {
            addCriterion("ptr_dealStatus =", value, "ptrDealstatus");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusNotEqualTo(String value) {
            addCriterion("ptr_dealStatus <>", value, "ptrDealstatus");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusGreaterThan(String value) {
            addCriterion("ptr_dealStatus >", value, "ptrDealstatus");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_dealStatus >=", value, "ptrDealstatus");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusLessThan(String value) {
            addCriterion("ptr_dealStatus <", value, "ptrDealstatus");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusLessThanOrEqualTo(String value) {
            addCriterion("ptr_dealStatus <=", value, "ptrDealstatus");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusLike(String value) {
            addCriterion("ptr_dealStatus like", value, "ptrDealstatus");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusNotLike(String value) {
            addCriterion("ptr_dealStatus not like", value, "ptrDealstatus");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusIn(List<String> values) {
            addCriterion("ptr_dealStatus in", values, "ptrDealstatus");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusNotIn(List<String> values) {
            addCriterion("ptr_dealStatus not in", values, "ptrDealstatus");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusBetween(String value1, String value2) {
            addCriterion("ptr_dealStatus between", value1, value2, "ptrDealstatus");
            return (Criteria) this;
        }

        public Criteria andPtrDealstatusNotBetween(String value1, String value2) {
            addCriterion("ptr_dealStatus not between", value1, value2, "ptrDealstatus");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusIsNull() {
            addCriterion("ptr_backStatus is null");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusIsNotNull() {
            addCriterion("ptr_backStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusEqualTo(String value) {
            addCriterion("ptr_backStatus =", value, "ptrBackstatus");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusNotEqualTo(String value) {
            addCriterion("ptr_backStatus <>", value, "ptrBackstatus");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusGreaterThan(String value) {
            addCriterion("ptr_backStatus >", value, "ptrBackstatus");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_backStatus >=", value, "ptrBackstatus");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusLessThan(String value) {
            addCriterion("ptr_backStatus <", value, "ptrBackstatus");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusLessThanOrEqualTo(String value) {
            addCriterion("ptr_backStatus <=", value, "ptrBackstatus");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusLike(String value) {
            addCriterion("ptr_backStatus like", value, "ptrBackstatus");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusNotLike(String value) {
            addCriterion("ptr_backStatus not like", value, "ptrBackstatus");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusIn(List<String> values) {
            addCriterion("ptr_backStatus in", values, "ptrBackstatus");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusNotIn(List<String> values) {
            addCriterion("ptr_backStatus not in", values, "ptrBackstatus");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusBetween(String value1, String value2) {
            addCriterion("ptr_backStatus between", value1, value2, "ptrBackstatus");
            return (Criteria) this;
        }

        public Criteria andPtrBackstatusNotBetween(String value1, String value2) {
            addCriterion("ptr_backStatus not between", value1, value2, "ptrBackstatus");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkIsNull() {
            addCriterion("ptr_remark is null");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkIsNotNull() {
            addCriterion("ptr_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkEqualTo(String value) {
            addCriterion("ptr_remark =", value, "ptrRemark");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkNotEqualTo(String value) {
            addCriterion("ptr_remark <>", value, "ptrRemark");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkGreaterThan(String value) {
            addCriterion("ptr_remark >", value, "ptrRemark");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ptr_remark >=", value, "ptrRemark");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkLessThan(String value) {
            addCriterion("ptr_remark <", value, "ptrRemark");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkLessThanOrEqualTo(String value) {
            addCriterion("ptr_remark <=", value, "ptrRemark");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkLike(String value) {
            addCriterion("ptr_remark like", value, "ptrRemark");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkNotLike(String value) {
            addCriterion("ptr_remark not like", value, "ptrRemark");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkIn(List<String> values) {
            addCriterion("ptr_remark in", values, "ptrRemark");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkNotIn(List<String> values) {
            addCriterion("ptr_remark not in", values, "ptrRemark");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkBetween(String value1, String value2) {
            addCriterion("ptr_remark between", value1, value2, "ptrRemark");
            return (Criteria) this;
        }

        public Criteria andPtrRemarkNotBetween(String value1, String value2) {
            addCriterion("ptr_remark not between", value1, value2, "ptrRemark");
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