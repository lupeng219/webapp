package com.baibao.web.p2p.generator.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class P2p_repayment_bill_transExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public P2p_repayment_bill_transExample() {
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

        public Criteria andPrtRepaybillnoIsNull() {
            addCriterion("prt_repaybillNo is null");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoIsNotNull() {
            addCriterion("prt_repaybillNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoEqualTo(String value) {
            addCriterion("prt_repaybillNo =", value, "prtRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoNotEqualTo(String value) {
            addCriterion("prt_repaybillNo <>", value, "prtRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoGreaterThan(String value) {
            addCriterion("prt_repaybillNo >", value, "prtRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoGreaterThanOrEqualTo(String value) {
            addCriterion("prt_repaybillNo >=", value, "prtRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoLessThan(String value) {
            addCriterion("prt_repaybillNo <", value, "prtRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoLessThanOrEqualTo(String value) {
            addCriterion("prt_repaybillNo <=", value, "prtRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoLike(String value) {
            addCriterion("prt_repaybillNo like", value, "prtRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoNotLike(String value) {
            addCriterion("prt_repaybillNo not like", value, "prtRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoIn(List<String> values) {
            addCriterion("prt_repaybillNo in", values, "prtRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoNotIn(List<String> values) {
            addCriterion("prt_repaybillNo not in", values, "prtRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoBetween(String value1, String value2) {
            addCriterion("prt_repaybillNo between", value1, value2, "prtRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaybillnoNotBetween(String value1, String value2) {
            addCriterion("prt_repaybillNo not between", value1, value2, "prtRepaybillno");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoIsNull() {
            addCriterion("prt_productNo is null");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoIsNotNull() {
            addCriterion("prt_productNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoEqualTo(String value) {
            addCriterion("prt_productNo =", value, "prtProductno");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoNotEqualTo(String value) {
            addCriterion("prt_productNo <>", value, "prtProductno");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoGreaterThan(String value) {
            addCriterion("prt_productNo >", value, "prtProductno");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoGreaterThanOrEqualTo(String value) {
            addCriterion("prt_productNo >=", value, "prtProductno");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoLessThan(String value) {
            addCriterion("prt_productNo <", value, "prtProductno");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoLessThanOrEqualTo(String value) {
            addCriterion("prt_productNo <=", value, "prtProductno");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoLike(String value) {
            addCriterion("prt_productNo like", value, "prtProductno");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoNotLike(String value) {
            addCriterion("prt_productNo not like", value, "prtProductno");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoIn(List<String> values) {
            addCriterion("prt_productNo in", values, "prtProductno");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoNotIn(List<String> values) {
            addCriterion("prt_productNo not in", values, "prtProductno");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoBetween(String value1, String value2) {
            addCriterion("prt_productNo between", value1, value2, "prtProductno");
            return (Criteria) this;
        }

        public Criteria andPrtProductnoNotBetween(String value1, String value2) {
            addCriterion("prt_productNo not between", value1, value2, "prtProductno");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoIsNull() {
            addCriterion("prt_tradeFlowNo is null");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoIsNotNull() {
            addCriterion("prt_tradeFlowNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoEqualTo(String value) {
            addCriterion("prt_tradeFlowNo =", value, "prtTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoNotEqualTo(String value) {
            addCriterion("prt_tradeFlowNo <>", value, "prtTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoGreaterThan(String value) {
            addCriterion("prt_tradeFlowNo >", value, "prtTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoGreaterThanOrEqualTo(String value) {
            addCriterion("prt_tradeFlowNo >=", value, "prtTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoLessThan(String value) {
            addCriterion("prt_tradeFlowNo <", value, "prtTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoLessThanOrEqualTo(String value) {
            addCriterion("prt_tradeFlowNo <=", value, "prtTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoLike(String value) {
            addCriterion("prt_tradeFlowNo like", value, "prtTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoNotLike(String value) {
            addCriterion("prt_tradeFlowNo not like", value, "prtTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoIn(List<String> values) {
            addCriterion("prt_tradeFlowNo in", values, "prtTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoNotIn(List<String> values) {
            addCriterion("prt_tradeFlowNo not in", values, "prtTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoBetween(String value1, String value2) {
            addCriterion("prt_tradeFlowNo between", value1, value2, "prtTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrtTradeflownoNotBetween(String value1, String value2) {
            addCriterion("prt_tradeFlowNo not between", value1, value2, "prtTradeflowno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqIsNull() {
            addCriterion("prt_repaymentSeq is null");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqIsNotNull() {
            addCriterion("prt_repaymentSeq is not null");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqEqualTo(String value) {
            addCriterion("prt_repaymentSeq =", value, "prtRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqNotEqualTo(String value) {
            addCriterion("prt_repaymentSeq <>", value, "prtRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqGreaterThan(String value) {
            addCriterion("prt_repaymentSeq >", value, "prtRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqGreaterThanOrEqualTo(String value) {
            addCriterion("prt_repaymentSeq >=", value, "prtRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqLessThan(String value) {
            addCriterion("prt_repaymentSeq <", value, "prtRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqLessThanOrEqualTo(String value) {
            addCriterion("prt_repaymentSeq <=", value, "prtRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqLike(String value) {
            addCriterion("prt_repaymentSeq like", value, "prtRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqNotLike(String value) {
            addCriterion("prt_repaymentSeq not like", value, "prtRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqIn(List<String> values) {
            addCriterion("prt_repaymentSeq in", values, "prtRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqNotIn(List<String> values) {
            addCriterion("prt_repaymentSeq not in", values, "prtRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqBetween(String value1, String value2) {
            addCriterion("prt_repaymentSeq between", value1, value2, "prtRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymentseqNotBetween(String value1, String value2) {
            addCriterion("prt_repaymentSeq not between", value1, value2, "prtRepaymentseq");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoIsNull() {
            addCriterion("prt_OutAccountNo is null");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoIsNotNull() {
            addCriterion("prt_OutAccountNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoEqualTo(String value) {
            addCriterion("prt_OutAccountNo =", value, "prtOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoNotEqualTo(String value) {
            addCriterion("prt_OutAccountNo <>", value, "prtOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoGreaterThan(String value) {
            addCriterion("prt_OutAccountNo >", value, "prtOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoGreaterThanOrEqualTo(String value) {
            addCriterion("prt_OutAccountNo >=", value, "prtOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoLessThan(String value) {
            addCriterion("prt_OutAccountNo <", value, "prtOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoLessThanOrEqualTo(String value) {
            addCriterion("prt_OutAccountNo <=", value, "prtOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoLike(String value) {
            addCriterion("prt_OutAccountNo like", value, "prtOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoNotLike(String value) {
            addCriterion("prt_OutAccountNo not like", value, "prtOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoIn(List<String> values) {
            addCriterion("prt_OutAccountNo in", values, "prtOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoNotIn(List<String> values) {
            addCriterion("prt_OutAccountNo not in", values, "prtOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoBetween(String value1, String value2) {
            addCriterion("prt_OutAccountNo between", value1, value2, "prtOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtOutaccountnoNotBetween(String value1, String value2) {
            addCriterion("prt_OutAccountNo not between", value1, value2, "prtOutaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoIsNull() {
            addCriterion("prt_InAccountNo is null");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoIsNotNull() {
            addCriterion("prt_InAccountNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoEqualTo(String value) {
            addCriterion("prt_InAccountNo =", value, "prtInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoNotEqualTo(String value) {
            addCriterion("prt_InAccountNo <>", value, "prtInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoGreaterThan(String value) {
            addCriterion("prt_InAccountNo >", value, "prtInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoGreaterThanOrEqualTo(String value) {
            addCriterion("prt_InAccountNo >=", value, "prtInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoLessThan(String value) {
            addCriterion("prt_InAccountNo <", value, "prtInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoLessThanOrEqualTo(String value) {
            addCriterion("prt_InAccountNo <=", value, "prtInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoLike(String value) {
            addCriterion("prt_InAccountNo like", value, "prtInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoNotLike(String value) {
            addCriterion("prt_InAccountNo not like", value, "prtInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoIn(List<String> values) {
            addCriterion("prt_InAccountNo in", values, "prtInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoNotIn(List<String> values) {
            addCriterion("prt_InAccountNo not in", values, "prtInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoBetween(String value1, String value2) {
            addCriterion("prt_InAccountNo between", value1, value2, "prtInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtInaccountnoNotBetween(String value1, String value2) {
            addCriterion("prt_InAccountNo not between", value1, value2, "prtInaccountno");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryIsNull() {
            addCriterion("prt_repayCategory is null");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryIsNotNull() {
            addCriterion("prt_repayCategory is not null");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryEqualTo(String value) {
            addCriterion("prt_repayCategory =", value, "prtRepaycategory");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryNotEqualTo(String value) {
            addCriterion("prt_repayCategory <>", value, "prtRepaycategory");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryGreaterThan(String value) {
            addCriterion("prt_repayCategory >", value, "prtRepaycategory");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryGreaterThanOrEqualTo(String value) {
            addCriterion("prt_repayCategory >=", value, "prtRepaycategory");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryLessThan(String value) {
            addCriterion("prt_repayCategory <", value, "prtRepaycategory");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryLessThanOrEqualTo(String value) {
            addCriterion("prt_repayCategory <=", value, "prtRepaycategory");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryLike(String value) {
            addCriterion("prt_repayCategory like", value, "prtRepaycategory");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryNotLike(String value) {
            addCriterion("prt_repayCategory not like", value, "prtRepaycategory");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryIn(List<String> values) {
            addCriterion("prt_repayCategory in", values, "prtRepaycategory");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryNotIn(List<String> values) {
            addCriterion("prt_repayCategory not in", values, "prtRepaycategory");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryBetween(String value1, String value2) {
            addCriterion("prt_repayCategory between", value1, value2, "prtRepaycategory");
            return (Criteria) this;
        }

        public Criteria andPrtRepaycategoryNotBetween(String value1, String value2) {
            addCriterion("prt_repayCategory not between", value1, value2, "prtRepaycategory");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountIsNull() {
            addCriterion("prt_transAmount is null");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountIsNotNull() {
            addCriterion("prt_transAmount is not null");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountEqualTo(String value) {
            addCriterion("prt_transAmount =", value, "prtTransamount");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountNotEqualTo(String value) {
            addCriterion("prt_transAmount <>", value, "prtTransamount");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountGreaterThan(String value) {
            addCriterion("prt_transAmount >", value, "prtTransamount");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountGreaterThanOrEqualTo(String value) {
            addCriterion("prt_transAmount >=", value, "prtTransamount");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountLessThan(String value) {
            addCriterion("prt_transAmount <", value, "prtTransamount");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountLessThanOrEqualTo(String value) {
            addCriterion("prt_transAmount <=", value, "prtTransamount");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountLike(String value) {
            addCriterion("prt_transAmount like", value, "prtTransamount");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountNotLike(String value) {
            addCriterion("prt_transAmount not like", value, "prtTransamount");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountIn(List<String> values) {
            addCriterion("prt_transAmount in", values, "prtTransamount");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountNotIn(List<String> values) {
            addCriterion("prt_transAmount not in", values, "prtTransamount");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountBetween(String value1, String value2) {
            addCriterion("prt_transAmount between", value1, value2, "prtTransamount");
            return (Criteria) this;
        }

        public Criteria andPrtTransamountNotBetween(String value1, String value2) {
            addCriterion("prt_transAmount not between", value1, value2, "prtTransamount");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeIsNull() {
            addCriterion("prt_repaymentType is null");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeIsNotNull() {
            addCriterion("prt_repaymentType is not null");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeEqualTo(String value) {
            addCriterion("prt_repaymentType =", value, "prtRepaymenttype");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeNotEqualTo(String value) {
            addCriterion("prt_repaymentType <>", value, "prtRepaymenttype");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeGreaterThan(String value) {
            addCriterion("prt_repaymentType >", value, "prtRepaymenttype");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeGreaterThanOrEqualTo(String value) {
            addCriterion("prt_repaymentType >=", value, "prtRepaymenttype");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeLessThan(String value) {
            addCriterion("prt_repaymentType <", value, "prtRepaymenttype");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeLessThanOrEqualTo(String value) {
            addCriterion("prt_repaymentType <=", value, "prtRepaymenttype");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeLike(String value) {
            addCriterion("prt_repaymentType like", value, "prtRepaymenttype");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeNotLike(String value) {
            addCriterion("prt_repaymentType not like", value, "prtRepaymenttype");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeIn(List<String> values) {
            addCriterion("prt_repaymentType in", values, "prtRepaymenttype");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeNotIn(List<String> values) {
            addCriterion("prt_repaymentType not in", values, "prtRepaymenttype");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeBetween(String value1, String value2) {
            addCriterion("prt_repaymentType between", value1, value2, "prtRepaymenttype");
            return (Criteria) this;
        }

        public Criteria andPrtRepaymenttypeNotBetween(String value1, String value2) {
            addCriterion("prt_repaymentType not between", value1, value2, "prtRepaymenttype");
            return (Criteria) this;
        }

        public Criteria andPrtRepaytimeIsNull() {
            addCriterion("prt_repayTime is null");
            return (Criteria) this;
        }

        public Criteria andPrtRepaytimeIsNotNull() {
            addCriterion("prt_repayTime is not null");
            return (Criteria) this;
        }

        public Criteria andPrtRepaytimeEqualTo(Date value) {
            addCriterion("prt_repayTime =", value, "prtRepaytime");
            return (Criteria) this;
        }

        public Criteria andPrtRepaytimeNotEqualTo(Date value) {
            addCriterion("prt_repayTime <>", value, "prtRepaytime");
            return (Criteria) this;
        }

        public Criteria andPrtRepaytimeGreaterThan(Date value) {
            addCriterion("prt_repayTime >", value, "prtRepaytime");
            return (Criteria) this;
        }

        public Criteria andPrtRepaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("prt_repayTime >=", value, "prtRepaytime");
            return (Criteria) this;
        }

        public Criteria andPrtRepaytimeLessThan(Date value) {
            addCriterion("prt_repayTime <", value, "prtRepaytime");
            return (Criteria) this;
        }

        public Criteria andPrtRepaytimeLessThanOrEqualTo(Date value) {
            addCriterion("prt_repayTime <=", value, "prtRepaytime");
            return (Criteria) this;
        }

        public Criteria andPrtRepaytimeIn(List<Date> values) {
            addCriterion("prt_repayTime in", values, "prtRepaytime");
            return (Criteria) this;
        }

        public Criteria andPrtRepaytimeNotIn(List<Date> values) {
            addCriterion("prt_repayTime not in", values, "prtRepaytime");
            return (Criteria) this;
        }

        public Criteria andPrtRepaytimeBetween(Date value1, Date value2) {
            addCriterion("prt_repayTime between", value1, value2, "prtRepaytime");
            return (Criteria) this;
        }

        public Criteria andPrtRepaytimeNotBetween(Date value1, Date value2) {
            addCriterion("prt_repayTime not between", value1, value2, "prtRepaytime");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusIsNull() {
            addCriterion("prt_repayStatus is null");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusIsNotNull() {
            addCriterion("prt_repayStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusEqualTo(String value) {
            addCriterion("prt_repayStatus =", value, "prtRepaystatus");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusNotEqualTo(String value) {
            addCriterion("prt_repayStatus <>", value, "prtRepaystatus");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusGreaterThan(String value) {
            addCriterion("prt_repayStatus >", value, "prtRepaystatus");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusGreaterThanOrEqualTo(String value) {
            addCriterion("prt_repayStatus >=", value, "prtRepaystatus");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusLessThan(String value) {
            addCriterion("prt_repayStatus <", value, "prtRepaystatus");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusLessThanOrEqualTo(String value) {
            addCriterion("prt_repayStatus <=", value, "prtRepaystatus");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusLike(String value) {
            addCriterion("prt_repayStatus like", value, "prtRepaystatus");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusNotLike(String value) {
            addCriterion("prt_repayStatus not like", value, "prtRepaystatus");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusIn(List<String> values) {
            addCriterion("prt_repayStatus in", values, "prtRepaystatus");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusNotIn(List<String> values) {
            addCriterion("prt_repayStatus not in", values, "prtRepaystatus");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusBetween(String value1, String value2) {
            addCriterion("prt_repayStatus between", value1, value2, "prtRepaystatus");
            return (Criteria) this;
        }

        public Criteria andPrtRepaystatusNotBetween(String value1, String value2) {
            addCriterion("prt_repayStatus not between", value1, value2, "prtRepaystatus");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeIsNull() {
            addCriterion("prt_host_response_time is null");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeIsNotNull() {
            addCriterion("prt_host_response_time is not null");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeEqualTo(String value) {
            addCriterion("prt_host_response_time =", value, "prtHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeNotEqualTo(String value) {
            addCriterion("prt_host_response_time <>", value, "prtHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeGreaterThan(String value) {
            addCriterion("prt_host_response_time >", value, "prtHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("prt_host_response_time >=", value, "prtHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeLessThan(String value) {
            addCriterion("prt_host_response_time <", value, "prtHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeLessThanOrEqualTo(String value) {
            addCriterion("prt_host_response_time <=", value, "prtHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeLike(String value) {
            addCriterion("prt_host_response_time like", value, "prtHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeNotLike(String value) {
            addCriterion("prt_host_response_time not like", value, "prtHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeIn(List<String> values) {
            addCriterion("prt_host_response_time in", values, "prtHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeNotIn(List<String> values) {
            addCriterion("prt_host_response_time not in", values, "prtHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeBetween(String value1, String value2) {
            addCriterion("prt_host_response_time between", value1, value2, "prtHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseTimeNotBetween(String value1, String value2) {
            addCriterion("prt_host_response_time not between", value1, value2, "prtHostResponseTime");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumIsNull() {
            addCriterion("prt_host_response_flowNum is null");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumIsNotNull() {
            addCriterion("prt_host_response_flowNum is not null");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumEqualTo(String value) {
            addCriterion("prt_host_response_flowNum =", value, "prtHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumNotEqualTo(String value) {
            addCriterion("prt_host_response_flowNum <>", value, "prtHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumGreaterThan(String value) {
            addCriterion("prt_host_response_flowNum >", value, "prtHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumGreaterThanOrEqualTo(String value) {
            addCriterion("prt_host_response_flowNum >=", value, "prtHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumLessThan(String value) {
            addCriterion("prt_host_response_flowNum <", value, "prtHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumLessThanOrEqualTo(String value) {
            addCriterion("prt_host_response_flowNum <=", value, "prtHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumLike(String value) {
            addCriterion("prt_host_response_flowNum like", value, "prtHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumNotLike(String value) {
            addCriterion("prt_host_response_flowNum not like", value, "prtHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumIn(List<String> values) {
            addCriterion("prt_host_response_flowNum in", values, "prtHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumNotIn(List<String> values) {
            addCriterion("prt_host_response_flowNum not in", values, "prtHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumBetween(String value1, String value2) {
            addCriterion("prt_host_response_flowNum between", value1, value2, "prtHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrtHostResponseFlownumNotBetween(String value1, String value2) {
            addCriterion("prt_host_response_flowNum not between", value1, value2, "prtHostResponseFlownum");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeIsNull() {
            addCriterion("prt_host_return_code is null");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeIsNotNull() {
            addCriterion("prt_host_return_code is not null");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeEqualTo(String value) {
            addCriterion("prt_host_return_code =", value, "prtHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeNotEqualTo(String value) {
            addCriterion("prt_host_return_code <>", value, "prtHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeGreaterThan(String value) {
            addCriterion("prt_host_return_code >", value, "prtHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeGreaterThanOrEqualTo(String value) {
            addCriterion("prt_host_return_code >=", value, "prtHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeLessThan(String value) {
            addCriterion("prt_host_return_code <", value, "prtHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeLessThanOrEqualTo(String value) {
            addCriterion("prt_host_return_code <=", value, "prtHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeLike(String value) {
            addCriterion("prt_host_return_code like", value, "prtHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeNotLike(String value) {
            addCriterion("prt_host_return_code not like", value, "prtHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeIn(List<String> values) {
            addCriterion("prt_host_return_code in", values, "prtHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeNotIn(List<String> values) {
            addCriterion("prt_host_return_code not in", values, "prtHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeBetween(String value1, String value2) {
            addCriterion("prt_host_return_code between", value1, value2, "prtHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnCodeNotBetween(String value1, String value2) {
            addCriterion("prt_host_return_code not between", value1, value2, "prtHostReturnCode");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageIsNull() {
            addCriterion("prt_host_return_message is null");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageIsNotNull() {
            addCriterion("prt_host_return_message is not null");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageEqualTo(String value) {
            addCriterion("prt_host_return_message =", value, "prtHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageNotEqualTo(String value) {
            addCriterion("prt_host_return_message <>", value, "prtHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageGreaterThan(String value) {
            addCriterion("prt_host_return_message >", value, "prtHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageGreaterThanOrEqualTo(String value) {
            addCriterion("prt_host_return_message >=", value, "prtHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageLessThan(String value) {
            addCriterion("prt_host_return_message <", value, "prtHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageLessThanOrEqualTo(String value) {
            addCriterion("prt_host_return_message <=", value, "prtHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageLike(String value) {
            addCriterion("prt_host_return_message like", value, "prtHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageNotLike(String value) {
            addCriterion("prt_host_return_message not like", value, "prtHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageIn(List<String> values) {
            addCriterion("prt_host_return_message in", values, "prtHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageNotIn(List<String> values) {
            addCriterion("prt_host_return_message not in", values, "prtHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageBetween(String value1, String value2) {
            addCriterion("prt_host_return_message between", value1, value2, "prtHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrtHostReturnMessageNotBetween(String value1, String value2) {
            addCriterion("prt_host_return_message not between", value1, value2, "prtHostReturnMessage");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoIsNull() {
            addCriterion("prt_outCustNo is null");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoIsNotNull() {
            addCriterion("prt_outCustNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoEqualTo(String value) {
            addCriterion("prt_outCustNo =", value, "prtOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoNotEqualTo(String value) {
            addCriterion("prt_outCustNo <>", value, "prtOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoGreaterThan(String value) {
            addCriterion("prt_outCustNo >", value, "prtOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoGreaterThanOrEqualTo(String value) {
            addCriterion("prt_outCustNo >=", value, "prtOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoLessThan(String value) {
            addCriterion("prt_outCustNo <", value, "prtOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoLessThanOrEqualTo(String value) {
            addCriterion("prt_outCustNo <=", value, "prtOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoLike(String value) {
            addCriterion("prt_outCustNo like", value, "prtOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoNotLike(String value) {
            addCriterion("prt_outCustNo not like", value, "prtOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoIn(List<String> values) {
            addCriterion("prt_outCustNo in", values, "prtOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoNotIn(List<String> values) {
            addCriterion("prt_outCustNo not in", values, "prtOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoBetween(String value1, String value2) {
            addCriterion("prt_outCustNo between", value1, value2, "prtOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrtOutcustnoNotBetween(String value1, String value2) {
            addCriterion("prt_outCustNo not between", value1, value2, "prtOutcustno");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoIsNull() {
            addCriterion("prt_inCustNo is null");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoIsNotNull() {
            addCriterion("prt_inCustNo is not null");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoEqualTo(String value) {
            addCriterion("prt_inCustNo =", value, "prtIncustno");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoNotEqualTo(String value) {
            addCriterion("prt_inCustNo <>", value, "prtIncustno");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoGreaterThan(String value) {
            addCriterion("prt_inCustNo >", value, "prtIncustno");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoGreaterThanOrEqualTo(String value) {
            addCriterion("prt_inCustNo >=", value, "prtIncustno");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoLessThan(String value) {
            addCriterion("prt_inCustNo <", value, "prtIncustno");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoLessThanOrEqualTo(String value) {
            addCriterion("prt_inCustNo <=", value, "prtIncustno");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoLike(String value) {
            addCriterion("prt_inCustNo like", value, "prtIncustno");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoNotLike(String value) {
            addCriterion("prt_inCustNo not like", value, "prtIncustno");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoIn(List<String> values) {
            addCriterion("prt_inCustNo in", values, "prtIncustno");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoNotIn(List<String> values) {
            addCriterion("prt_inCustNo not in", values, "prtIncustno");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoBetween(String value1, String value2) {
            addCriterion("prt_inCustNo between", value1, value2, "prtIncustno");
            return (Criteria) this;
        }

        public Criteria andPrtIncustnoNotBetween(String value1, String value2) {
            addCriterion("prt_inCustNo not between", value1, value2, "prtIncustno");
            return (Criteria) this;
        }

        public Criteria andPrtFeeIsNull() {
            addCriterion("prt_fee is null");
            return (Criteria) this;
        }

        public Criteria andPrtFeeIsNotNull() {
            addCriterion("prt_fee is not null");
            return (Criteria) this;
        }

        public Criteria andPrtFeeEqualTo(Long value) {
            addCriterion("prt_fee =", value, "prtFee");
            return (Criteria) this;
        }

        public Criteria andPrtFeeNotEqualTo(Long value) {
            addCriterion("prt_fee <>", value, "prtFee");
            return (Criteria) this;
        }

        public Criteria andPrtFeeGreaterThan(Long value) {
            addCriterion("prt_fee >", value, "prtFee");
            return (Criteria) this;
        }

        public Criteria andPrtFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("prt_fee >=", value, "prtFee");
            return (Criteria) this;
        }

        public Criteria andPrtFeeLessThan(Long value) {
            addCriterion("prt_fee <", value, "prtFee");
            return (Criteria) this;
        }

        public Criteria andPrtFeeLessThanOrEqualTo(Long value) {
            addCriterion("prt_fee <=", value, "prtFee");
            return (Criteria) this;
        }

        public Criteria andPrtFeeIn(List<Long> values) {
            addCriterion("prt_fee in", values, "prtFee");
            return (Criteria) this;
        }

        public Criteria andPrtFeeNotIn(List<Long> values) {
            addCriterion("prt_fee not in", values, "prtFee");
            return (Criteria) this;
        }

        public Criteria andPrtFeeBetween(Long value1, Long value2) {
            addCriterion("prt_fee between", value1, value2, "prtFee");
            return (Criteria) this;
        }

        public Criteria andPrtFeeNotBetween(Long value1, Long value2) {
            addCriterion("prt_fee not between", value1, value2, "prtFee");
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