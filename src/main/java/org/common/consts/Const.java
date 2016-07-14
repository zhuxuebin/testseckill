package org.common.consts;

/**
 * 
 * ClassName: Const
 * 
 * @Description: TODO
 * @author penghb <penghongbao@liangyibang.com>
 * @date 2016-4-26
 */
public class Const {
    public static final String APP_KEY = "84cf5ee2099c654aa03a5d70";
    /**
     * 删除标记, 0：正常, 1：删除, 2：审核
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";
    /**
     * 菜单 
     * f:一级菜单
     * m:二级菜单
     */
    public static final String firstMenu = "f";
    public static final String secondMenu = "m";

    /**
     * 布尔string
     */
    public static final String TRUE = "true";
    public static final String FALSE = "false";

    /**
     * 是/否
     */
    public static final String YES = "1";
    public static final String NO = "0";
    /**
     * 成功/失败
     */
    public static final int SUCCESS = 1;
    public static final int FAIL = 0;

    /**
     * 显示/隐藏
     */
    public static final String SHOW = "1";
    public static final String HIDE = "0";
    /**
     * 排序方式desc/asc
     */
    public static final String SORT_DESC = "desc";
    public static final String SORT_ASC = "asc";

    /**
     * 是否成功: 是/否
     */
    public static final Integer RESULT_TRUE = 1;
    public static final Integer RESULT_FALSE=0;
    
    

    /**
     * 默认空id
     */
    public static final Integer EMPTY_ID = 0;
    
    /**
     * 处方操作状态
     */
    /*发药*/
    public static final String RECIPEL_AUDIT_FY="FY";
    /*审核*/
    public static final String RECIPEL_AUDIT_SH="SH";
    /*收费*/
    public static final String RECIPEL_AUDIT_SF="SF";
    /*退费*/
    public static final String RECIPEL_AUDIT_TF="TF";
    /*划价*/
    public static final String RECIPEL_AUDIT_HJ="HJ";
    /**
     * 处方状态
     */
    /*发药*/
    public static final String RECIPEL_AUDIT_FY_YES="FY1";
    public static final String RECIPEL_AUDIT_FY_NO="FY0";
    /*审核*/
    public static final String RECIPEL_AUDIT_SH_NO="SH0";
    public static final String RECIPEL_AUDIT_SH_YES="SH1";
    /*收费*/
    public static final String RECIPEL_AUDIT_SF_NO_PAY="nopay";
    public static final String RECIPEL_AUDIT_SF_YES="SF1";
    public static final String RECIPEL_AUDIT_SF_NO="SF0";
    /*划价 HJ0已登记HJ1已提交*/
    public static final String RECIPEL_AUDIT_HJ_NO="HJ0";
    public static final String RECIPEL_AUDIT_HJ_YES="HJ1";
    
    /*字典类型定义*/
    /*处方来源*/
    public static final String RXTREATTYPE="RXTreatType";
    /*处方来源*/
    public static final String MEMBER_NATION="MEMBER_Nation";
    /*每袋ml*/
    public static final String RXDOSEPERTIME="RXDosePerTime";
    /*单位ml*/
    public static final String DRUG_UNITTYPE="DRUG_UNITTYPE";
    /*生辰*/
    public static final String MEMBER_BIRTHDAYHOUR="MEMBER_BirthdayHour";
    /*支付方式*/
    public static final String CHARGEPAYMENTTYPE="ChargePaymentType";
    
    /**
     * 交易类型字典
     */
    /* 进账 */
    public static final String TRANSACTION_TYPE_IN = "IN";
    /* 出账 */
    public static final String TRANSACTION_TYPE_OUT = "OUT";
    
    /**
     * 交易子类型字典 
    */
    /*正常消费*/
    public static final String TRANSACTION_SUB_TYPE_ZCXF = "ZCXF";
    /*会员费*/
    public static final String TRANSACTION_SUB_TYPE_HYF= "HYF";
    /*转出*/
    public static final String TRANSACTION_SUB_TYPE_ZC = "ZC";
    /*退费*/
    public static final String TRANSACTION_SUB_TYPE_TF = "TF";
    /*退卡*/
    public static final String TRANSACTION_SUB_TYPE_TK = "TK";
    /*转入*/
    public static final String TRANSACTION_SUB_TYPE_ZR = "ZR";
    /*会员卡充值*/
    public static final String TRANSACTION_SUB_TYPE_HYKCZ = "HYKCZ";
    /**
     * 交易方式
     */
    /*现金*/
    public static final String TRANSACTION_WAY_XJ="XJ";
    /*POS*/
    public static final String TRANSACTION_WAY_POS="POS";
    /*支票*/
    public static final String TRANSACTION_WAY_ZP="ZP";
    /*会员卡*/
    public static final String TRANSACTION_WAY_HYK="HYK";
    /*他人代付*/
    public static final String TRANSACTION_WAY_TRDF="TRDF";
    /*优惠券代金卡*/
    public static final String TRANSACTION_WAY_YHQ="YHQ";
    /*员工代金卡*/
    public static final String TRANSACTION_WAY_YGDJK="YGDJK";
    /*公关卡*/
    public static final String TRANSACTION_WAY_GGK="GGK";
    /*转账 保险*/
    public static final String TRANSACTION_WAY_ZZBX="ZZBX";
    /*企业支付*/
    public static final String TRANSACTION_WAY_QY="QY";
    /*专科支付*/
    public static final String TRANSACTION_WAY_ZKZF="ZKZF";
    
    /**
     * 发药状态
     */
    /*未发药*/
    public static final String BREWING_STATE_WF="0";
    /*已发药*/
    public static final String BREWING_STATE_YF="1";
    /*已煎*/
    public static final String BREWING_STATE_YJ="2";
    /*已快递*/
    public static final String BREWING_STATE_YKD="3";
    
    /*城市等级*/
    public static final Integer CITY_LEVEL = 1;
}
