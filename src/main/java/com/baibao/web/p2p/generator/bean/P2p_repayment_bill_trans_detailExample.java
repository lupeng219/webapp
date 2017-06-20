package com.baibao.web.p2p.generator.bean;

import java.util.ArrayList;
import java.util.List;

public class P2p_repayment_bill_trans_detailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_repayment_bill_trans_detailExample() {
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

        public Criteria andPrdIncomebillnoIsNull() {
            addCriterion("prd_incomebillNo is null");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoIsNotNull() {
            addCriterion("prd_incomebillNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoEqualTo(String value) {
            addCriterion("prd_incomebillNo =", value, "prdIncomebillno");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoNotEqualTo(String value) {
            addCriterion("prd_incomebillNo <>", value, "prdIncomebillno");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoGreaterThan(String value) {
            addCriterion("prd_incomebillNo >", value, "prdIncomebillno");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoGreaterThanOrEqualTo(String value) {
            addCriterion("prd_incomebillNo >=", value, "prdIncomebillno");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoLessThan(String value) {
            addCriterion("prd_incomebillNo <", value, "prdIncomebillno");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoLessThanOrEqualTo(String value) {
            addCriterion("prd_incomebillNo <=", value, "prdIncomebillno");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoLike(String value) {
            addCriterion("prd_incomebillNo like", value, "prdIncomebillno");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoNotLike(String value) {
            addCriterion("prd_incomebillNo not like", value, "prdIncomebillno");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoIn(List<String> values) {
            addCriterion("prd_incomebillNo in", values, "prdIncomebillno");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoNotIn(List<String> values) {
            addCriterion("prd_incomebillNo not in", values, "prdIncomebillno");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoBetween(String value1, String value2) {
            addCriterion("prd_incomebillNo between", value1, value2, "prdIncomebillno");
            return (Criteria) this;
        }

        public Criteria andPrdIncomebillnoNotBetween(String value1, String value2) {
            addCriterion("prd_incomebillNo not between", value1, value2, "prdIncomebillno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoIsNull() {
            addCriterion("prd_repaybillNo is null");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoIsNotNull() {
            addCriterion("prd_repaybillNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoEqualTo(String value) {
            addCriterion("prd_repaybillNo =", value, "prdRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoNotEqualTo(String value) {
            addCriterion("prd_repaybillNo <>", value, "prdRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoGreaterThan(String value) {
            addCriterion("prd_repaybillNo >", value, "prdRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoGreaterThanOrEqualTo(String value) {
            addCriterion("prd_repaybillNo >=", value, "prdRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoLessThan(String value) {
            addCriterion("prd_repaybillNo <", value, "prdRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoLessThanOrEqualTo(String value) {
            addCriterion("prd_repaybillNo <=", value, "prdRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoLike(String value) {
            addCriterion("prd_repaybillNo like", value, "prdRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoNotLike(String value) {
            addCriterion("prd_repaybillNo not like", value, "prdRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoIn(List<String> values) {
            addCriterion("prd_repaybillNo in", values, "prdRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoNotIn(List<String> values) {
            addCriterion("prd_repaybillNo not in", values, "prdRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoBetween(String value1, String value2) {
            addCriterion("prd_repaybillNo between", value1, value2, "prdRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaybillnoNotBetween(String value1, String value2) {
            addCriterion("prd_repaybillNo not between", value1, value2, "prdRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoIsNull() {
            addCriterion("prd_tenderTransFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoIsNotNull() {
            addCriterion("prd_tenderTransFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoEqualTo(String value) {
            addCriterion("prd_tenderTransFlowNo =", value, "prdTendertransflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoNotEqualTo(String value) {
            addCriterion("prd_tenderTransFlowNo <>", value, "prdTendertransflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoGreaterThan(String value) {
            addCriterion("prd_tenderTransFlowNo >", value, "prdTendertransflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoGreaterThanOrEqualTo(String value) {
            addCriterion("prd_tenderTransFlowNo >=", value, "prdTendertransflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoLessThan(String value) {
            addCriterion("prd_tenderTransFlowNo <", value, "prdTendertransflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoLessThanOrEqualTo(String value) {
            addCriterion("prd_tenderTransFlowNo <=", value, "prdTendertransflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoLike(String value) {
            addCriterion("prd_tenderTransFlowNo like", value, "prdTendertransflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoNotLike(String value) {
            addCriterion("prd_tenderTransFlowNo not like", value, "prdTendertransflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoIn(List<String> values) {
            addCriterion("prd_tenderTransFlowNo in", values, "prdTendertransflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoNotIn(List<String> values) {
            addCriterion("prd_tenderTransFlowNo not in", values, "prdTendertransflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoBetween(String value1, String value2) {
            addCriterion("prd_tenderTransFlowNo between", value1, value2, "prdTendertransflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTendertransflownoNotBetween(String value1, String value2) {
            addCriterion("prd_tenderTransFlowNo not between", value1, value2, "prdTendertransflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoIsNull() {
            addCriterion("prd_tradeFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoIsNotNull() {
            addCriterion("prd_tradeFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoEqualTo(String value) {
            addCriterion("prd_tradeFlowNo =", value, "prdTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoNotEqualTo(String value) {
            addCriterion("prd_tradeFlowNo <>", value, "prdTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoGreaterThan(String value) {
            addCriterion("prd_tradeFlowNo >", value, "prdTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoGreaterThanOrEqualTo(String value) {
            addCriterion("prd_tradeFlowNo >=", value, "prdTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoLessThan(String value) {
            addCriterion("prd_tradeFlowNo <", value, "prdTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoLessThanOrEqualTo(String value) {
            addCriterion("prd_tradeFlowNo <=", value, "prdTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoLike(String value) {
            addCriterion("prd_tradeFlowNo like", value, "prdTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoNotLike(String value) {
            addCriterion("prd_tradeFlowNo not like", value, "prdTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoIn(List<String> values) {
            addCriterion("prd_tradeFlowNo in", values, "prdTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoNotIn(List<String> values) {
            addCriterion("prd_tradeFlowNo not in", values, "prdTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoBetween(String value1, String value2) {
            addCriterion("prd_tradeFlowNo between", value1, value2, "prdTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrdTradeflownoNotBetween(String value1, String value2) {
            addCriterion("prd_tradeFlowNo not between", value1, value2, "prdTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoIsNull() {
            addCriterion("prd_OutAccountNo is null");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoIsNotNull() {
            addCriterion("prd_OutAccountNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoEqualTo(String value) {
            addCriterion("prd_OutAccountNo =", value, "prdOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoNotEqualTo(String value) {
            addCriterion("prd_OutAccountNo <>", value, "prdOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoGreaterThan(String value) {
            addCriterion("prd_OutAccountNo >", value, "prdOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoGreaterThanOrEqualTo(String value) {
            addCriterion("prd_OutAccountNo >=", value, "prdOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoLessThan(String value) {
            addCriterion("prd_OutAccountNo <", value, "prdOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoLessThanOrEqualTo(String value) {
            addCriterion("prd_OutAccountNo <=", value, "prdOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoLike(String value) {
            addCriterion("prd_OutAccountNo like", value, "prdOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoNotLike(String value) {
            addCriterion("prd_OutAccountNo not like", value, "prdOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoIn(List<String> values) {
            addCriterion("prd_OutAccountNo in", values, "prdOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoNotIn(List<String> values) {
            addCriterion("prd_OutAccountNo not in", values, "prdOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoBetween(String value1, String value2) {
            addCriterion("prd_OutAccountNo between", value1, value2, "prdOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdOutaccountnoNotBetween(String value1, String value2) {
            addCriterion("prd_OutAccountNo not between", value1, value2, "prdOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoIsNull() {
            addCriterion("prd_InAccountNo is null");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoIsNotNull() {
            addCriterion("prd_InAccountNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoEqualTo(String value) {
            addCriterion("prd_InAccountNo =", value, "prdInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoNotEqualTo(String value) {
            addCriterion("prd_InAccountNo <>", value, "prdInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoGreaterThan(String value) {
            addCriterion("prd_InAccountNo >", value, "prdInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoGreaterThanOrEqualTo(String value) {
            addCriterion("prd_InAccountNo >=", value, "prdInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoLessThan(String value) {
            addCriterion("prd_InAccountNo <", value, "prdInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoLessThanOrEqualTo(String value) {
            addCriterion("prd_InAccountNo <=", value, "prdInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoLike(String value) {
            addCriterion("prd_InAccountNo like", value, "prdInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoNotLike(String value) {
            addCriterion("prd_InAccountNo not like", value, "prdInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoIn(List<String> values) {
            addCriterion("prd_InAccountNo in", values, "prdInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoNotIn(List<String> values) {
            addCriterion("prd_InAccountNo not in", values, "prdInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoBetween(String value1, String value2) {
            addCriterion("prd_InAccountNo between", value1, value2, "prdInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdInaccountnoNotBetween(String value1, String value2) {
            addCriterion("prd_InAccountNo not between", value1, value2, "prdInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqIsNull() {
            addCriterion("prd_repaymentSeq is null");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqIsNotNull() {
            addCriterion("prd_repaymentSeq is not null");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqEqualTo(String value) {
            addCriterion("prd_repaymentSeq =", value, "prdRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqNotEqualTo(String value) {
            addCriterion("prd_repaymentSeq <>", value, "prdRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqGreaterThan(String value) {
            addCriterion("prd_repaymentSeq >", value, "prdRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqGreaterThanOrEqualTo(String value) {
            addCriterion("prd_repaymentSeq >=", value, "prdRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqLessThan(String value) {
            addCriterion("prd_repaymentSeq <", value, "prdRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqLessThanOrEqualTo(String value) {
            addCriterion("prd_repaymentSeq <=", value, "prdRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqLike(String value) {
            addCriterion("prd_repaymentSeq like", value, "prdRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqNotLike(String value) {
            addCriterion("prd_repaymentSeq not like", value, "prdRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqIn(List<String> values) {
            addCriterion("prd_repaymentSeq in", values, "prdRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqNotIn(List<String> values) {
            addCriterion("prd_repaymentSeq not in", values, "prdRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqBetween(String value1, String value2) {
            addCriterion("prd_repaymentSeq between", value1, value2, "prdRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentseqNotBetween(String value1, String value2) {
            addCriterion("prd_repaymentSeq not between", value1, value2, "prdRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyIsNull() {
            addCriterion("prd_repaymentMoney is null");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyIsNotNull() {
            addCriterion("prd_repaymentMoney is not null");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyEqualTo(String value) {
            addCriterion("prd_repaymentMoney =", value, "prdRepaymentmoney");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyNotEqualTo(String value) {
            addCriterion("prd_repaymentMoney <>", value, "prdRepaymentmoney");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyGreaterThan(String value) {
            addCriterion("prd_repaymentMoney >", value, "prdRepaymentmoney");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyGreaterThanOrEqualTo(String value) {
            addCriterion("prd_repaymentMoney >=", value, "prdRepaymentmoney");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyLessThan(String value) {
            addCriterion("prd_repaymentMoney <", value, "prdRepaymentmoney");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyLessThanOrEqualTo(String value) {
            addCriterion("prd_repaymentMoney <=", value, "prdRepaymentmoney");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyLike(String value) {
            addCriterion("prd_repaymentMoney like", value, "prdRepaymentmoney");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyNotLike(String value) {
            addCriterion("prd_repaymentMoney not like", value, "prdRepaymentmoney");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyIn(List<String> values) {
            addCriterion("prd_repaymentMoney in", values, "prdRepaymentmoney");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyNotIn(List<String> values) {
            addCriterion("prd_repaymentMoney not in", values, "prdRepaymentmoney");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyBetween(String value1, String value2) {
            addCriterion("prd_repaymentMoney between", value1, value2, "prdRepaymentmoney");
            return (Criteria) this;
        }

        public Criteria andPrdRepaymentmoneyNotBetween(String value1, String value2) {
            addCriterion("prd_repaymentMoney not between", value1, value2, "prdRepaymentmoney");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeIsNull() {
            addCriterion("prd_tenderType is null");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeIsNotNull() {
            addCriterion("prd_tenderType is not null");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeEqualTo(String value) {
            addCriterion("prd_tenderType =", value, "prdTendertype");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeNotEqualTo(String value) {
            addCriterion("prd_tenderType <>", value, "prdTendertype");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeGreaterThan(String value) {
            addCriterion("prd_tenderType >", value, "prdTendertype");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeGreaterThanOrEqualTo(String value) {
            addCriterion("prd_tenderType >=", value, "prdTendertype");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeLessThan(String value) {
            addCriterion("prd_tenderType <", value, "prdTendertype");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeLessThanOrEqualTo(String value) {
            addCriterion("prd_tenderType <=", value, "prdTendertype");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeLike(String value) {
            addCriterion("prd_tenderType like", value, "prdTendertype");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeNotLike(String value) {
            addCriterion("prd_tenderType not like", value, "prdTendertype");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeIn(List<String> values) {
            addCriterion("prd_tenderType in", values, "prdTendertype");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeNotIn(List<String> values) {
            addCriterion("prd_tenderType not in", values, "prdTendertype");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeBetween(String value1, String value2) {
            addCriterion("prd_tenderType between", value1, value2, "prdTendertype");
            return (Criteria) this;
        }

        public Criteria andPrdTendertypeNotBetween(String value1, String value2) {
            addCriterion("prd_tenderType not between", value1, value2, "prdTendertype");
            return (Criteria) this;
        }

        public Criteria andPrdStatusIsNull() {
            addCriterion("prd_status is null");
            return (Criteria) this;
        }

        public Criteria andPrdStatusIsNotNull() {
            addCriterion("prd_status is not null");
            return (Criteria) this;
        }

        public Criteria andPrdStatusEqualTo(String value) {
            addCriterion("prd_status =", value, "prdStatus");
            return (Criteria) this;
        }

        public Criteria andPrdStatusNotEqualTo(String value) {
            addCriterion("prd_status <>", value, "prdStatus");
            return (Criteria) this;
        }

        public Criteria andPrdStatusGreaterThan(String value) {
            addCriterion("prd_status >", value, "prdStatus");
            return (Criteria) this;
        }

        public Criteria andPrdStatusGreaterThanOrEqualTo(String value) {
            addCriterion("prd_status >=", value, "prdStatus");
            return (Criteria) this;
        }

        public Criteria andPrdStatusLessThan(String value) {
            addCriterion("prd_status <", value, "prdStatus");
            return (Criteria) this;
        }

        public Criteria andPrdStatusLessThanOrEqualTo(String value) {
            addCriterion("prd_status <=", value, "prdStatus");
            return (Criteria) this;
        }

        public Criteria andPrdStatusLike(String value) {
            addCriterion("prd_status like", value, "prdStatus");
            return (Criteria) this;
        }

        public Criteria andPrdStatusNotLike(String value) {
            addCriterion("prd_status not like", value, "prdStatus");
            return (Criteria) this;
        }

        public Criteria andPrdStatusIn(List<String> values) {
            addCriterion("prd_status in", values, "prdStatus");
            return (Criteria) this;
        }

        public Criteria andPrdStatusNotIn(List<String> values) {
            addCriterion("prd_status not in", values, "prdStatus");
            return (Criteria) this;
        }

        public Criteria andPrdStatusBetween(String value1, String value2) {
            addCriterion("prd_status between", value1, value2, "prdStatus");
            return (Criteria) this;
        }

        public Criteria andPrdStatusNotBetween(String value1, String value2) {
            addCriterion("prd_status not between", value1, value2, "prdStatus");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeIsNull() {
            addCriterion("prd_host_response_time is null");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeIsNotNull() {
            addCriterion("prd_host_response_time is not null");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeEqualTo(String value) {
            addCriterion("prd_host_response_time =", value, "prdHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeNotEqualTo(String value) {
            addCriterion("prd_host_response_time <>", value, "prdHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeGreaterThan(String value) {
            addCriterion("prd_host_response_time >", value, "prdHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("prd_host_response_time >=", value, "prdHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeLessThan(String value) {
            addCriterion("prd_host_response_time <", value, "prdHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeLessThanOrEqualTo(String value) {
            addCriterion("prd_host_response_time <=", value, "prdHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeLike(String value) {
            addCriterion("prd_host_response_time like", value, "prdHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeNotLike(String value) {
            addCriterion("prd_host_response_time not like", value, "prdHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeIn(List<String> values) {
            addCriterion("prd_host_response_time in", values, "prdHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeNotIn(List<String> values) {
            addCriterion("prd_host_response_time not in", values, "prdHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeBetween(String value1, String value2) {
            addCriterion("prd_host_response_time between", value1, value2, "prdHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseTimeNotBetween(String value1, String value2) {
            addCriterion("prd_host_response_time not between", value1, value2, "prdHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumIsNull() {
            addCriterion("prd_host_response_flowNum is null");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumIsNotNull() {
            addCriterion("prd_host_response_flowNum is not null");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumEqualTo(String value) {
            addCriterion("prd_host_response_flowNum =", value, "prdHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumNotEqualTo(String value) {
            addCriterion("prd_host_response_flowNum <>", value, "prdHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumGreaterThan(String value) {
            addCriterion("prd_host_response_flowNum >", value, "prdHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumGreaterThanOrEqualTo(String value) {
            addCriterion("prd_host_response_flowNum >=", value, "prdHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumLessThan(String value) {
            addCriterion("prd_host_response_flowNum <", value, "prdHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumLessThanOrEqualTo(String value) {
            addCriterion("prd_host_response_flowNum <=", value, "prdHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumLike(String value) {
            addCriterion("prd_host_response_flowNum like", value, "prdHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumNotLike(String value) {
            addCriterion("prd_host_response_flowNum not like", value, "prdHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumIn(List<String> values) {
            addCriterion("prd_host_response_flowNum in", values, "prdHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumNotIn(List<String> values) {
            addCriterion("prd_host_response_flowNum not in", values, "prdHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumBetween(String value1, String value2) {
            addCriterion("prd_host_response_flowNum between", value1, value2, "prdHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrdHostResponseFlownumNotBetween(String value1, String value2) {
            addCriterion("prd_host_response_flowNum not between", value1, value2, "prdHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeIsNull() {
            addCriterion("prd_host_return_code is null");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeIsNotNull() {
            addCriterion("prd_host_return_code is not null");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeEqualTo(String value) {
            addCriterion("prd_host_return_code =", value, "prdHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeNotEqualTo(String value) {
            addCriterion("prd_host_return_code <>", value, "prdHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeGreaterThan(String value) {
            addCriterion("prd_host_return_code >", value, "prdHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeGreaterThanOrEqualTo(String value) {
            addCriterion("prd_host_return_code >=", value, "prdHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeLessThan(String value) {
            addCriterion("prd_host_return_code <", value, "prdHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeLessThanOrEqualTo(String value) {
            addCriterion("prd_host_return_code <=", value, "prdHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeLike(String value) {
            addCriterion("prd_host_return_code like", value, "prdHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeNotLike(String value) {
            addCriterion("prd_host_return_code not like", value, "prdHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeIn(List<String> values) {
            addCriterion("prd_host_return_code in", values, "prdHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeNotIn(List<String> values) {
            addCriterion("prd_host_return_code not in", values, "prdHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeBetween(String value1, String value2) {
            addCriterion("prd_host_return_code between", value1, value2, "prdHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnCodeNotBetween(String value1, String value2) {
            addCriterion("prd_host_return_code not between", value1, value2, "prdHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageIsNull() {
            addCriterion("prd_host_return_message is null");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageIsNotNull() {
            addCriterion("prd_host_return_message is not null");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageEqualTo(String value) {
            addCriterion("prd_host_return_message =", value, "prdHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageNotEqualTo(String value) {
            addCriterion("prd_host_return_message <>", value, "prdHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageGreaterThan(String value) {
            addCriterion("prd_host_return_message >", value, "prdHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageGreaterThanOrEqualTo(String value) {
            addCriterion("prd_host_return_message >=", value, "prdHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageLessThan(String value) {
            addCriterion("prd_host_return_message <", value, "prdHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageLessThanOrEqualTo(String value) {
            addCriterion("prd_host_return_message <=", value, "prdHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageLike(String value) {
            addCriterion("prd_host_return_message like", value, "prdHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageNotLike(String value) {
            addCriterion("prd_host_return_message not like", value, "prdHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageIn(List<String> values) {
            addCriterion("prd_host_return_message in", values, "prdHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageNotIn(List<String> values) {
            addCriterion("prd_host_return_message not in", values, "prdHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageBetween(String value1, String value2) {
            addCriterion("prd_host_return_message between", value1, value2, "prdHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrdHostReturnMessageNotBetween(String value1, String value2) {
            addCriterion("prd_host_return_message not between", value1, value2, "prdHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoIsNull() {
            addCriterion("prb_productNo is null");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoIsNotNull() {
            addCriterion("prb_productNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoEqualTo(String value) {
            addCriterion("prb_productNo =", value, "prbProductno");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoNotEqualTo(String value) {
            addCriterion("prb_productNo <>", value, "prbProductno");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoGreaterThan(String value) {
            addCriterion("prb_productNo >", value, "prbProductno");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoGreaterThanOrEqualTo(String value) {
            addCriterion("prb_productNo >=", value, "prbProductno");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoLessThan(String value) {
            addCriterion("prb_productNo <", value, "prbProductno");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoLessThanOrEqualTo(String value) {
            addCriterion("prb_productNo <=", value, "prbProductno");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoLike(String value) {
            addCriterion("prb_productNo like", value, "prbProductno");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoNotLike(String value) {
            addCriterion("prb_productNo not like", value, "prbProductno");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoIn(List<String> values) {
            addCriterion("prb_productNo in", values, "prbProductno");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoNotIn(List<String> values) {
            addCriterion("prb_productNo not in", values, "prbProductno");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoBetween(String value1, String value2) {
            addCriterion("prb_productNo between", value1, value2, "prbProductno");
            return (Criteria) this;
        }

        public Criteria andPrbProductnoNotBetween(String value1, String value2) {
            addCriterion("prb_productNo not between", value1, value2, "prbProductno");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoIsNull() {
            addCriterion("prd_outCustNo is null");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoIsNotNull() {
            addCriterion("prd_outCustNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoEqualTo(String value) {
            addCriterion("prd_outCustNo =", value, "prdOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoNotEqualTo(String value) {
            addCriterion("prd_outCustNo <>", value, "prdOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoGreaterThan(String value) {
            addCriterion("prd_outCustNo >", value, "prdOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoGreaterThanOrEqualTo(String value) {
            addCriterion("prd_outCustNo >=", value, "prdOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoLessThan(String value) {
            addCriterion("prd_outCustNo <", value, "prdOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoLessThanOrEqualTo(String value) {
            addCriterion("prd_outCustNo <=", value, "prdOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoLike(String value) {
            addCriterion("prd_outCustNo like", value, "prdOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoNotLike(String value) {
            addCriterion("prd_outCustNo not like", value, "prdOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoIn(List<String> values) {
            addCriterion("prd_outCustNo in", values, "prdOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoNotIn(List<String> values) {
            addCriterion("prd_outCustNo not in", values, "prdOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoBetween(String value1, String value2) {
            addCriterion("prd_outCustNo between", value1, value2, "prdOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrdOutcustnoNotBetween(String value1, String value2) {
            addCriterion("prd_outCustNo not between", value1, value2, "prdOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoIsNull() {
            addCriterion("prd_inCustNo is null");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoIsNotNull() {
            addCriterion("prd_inCustNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoEqualTo(String value) {
            addCriterion("prd_inCustNo =", value, "prdIncustno");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoNotEqualTo(String value) {
            addCriterion("prd_inCustNo <>", value, "prdIncustno");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoGreaterThan(String value) {
            addCriterion("prd_inCustNo >", value, "prdIncustno");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoGreaterThanOrEqualTo(String value) {
            addCriterion("prd_inCustNo >=", value, "prdIncustno");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoLessThan(String value) {
            addCriterion("prd_inCustNo <", value, "prdIncustno");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoLessThanOrEqualTo(String value) {
            addCriterion("prd_inCustNo <=", value, "prdIncustno");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoLike(String value) {
            addCriterion("prd_inCustNo like", value, "prdIncustno");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoNotLike(String value) {
            addCriterion("prd_inCustNo not like", value, "prdIncustno");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoIn(List<String> values) {
            addCriterion("prd_inCustNo in", values, "prdIncustno");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoNotIn(List<String> values) {
            addCriterion("prd_inCustNo not in", values, "prdIncustno");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoBetween(String value1, String value2) {
            addCriterion("prd_inCustNo between", value1, value2, "prdIncustno");
            return (Criteria) this;
        }

        public Criteria andPrdIncustnoNotBetween(String value1, String value2) {
            addCriterion("prd_inCustNo not between", value1, value2, "prdIncustno");
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