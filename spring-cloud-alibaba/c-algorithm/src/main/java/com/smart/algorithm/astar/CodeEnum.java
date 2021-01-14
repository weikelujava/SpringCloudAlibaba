package com.smart.algorithm.astar;

/**
 *
 * @version V1.0
 * @title: CodesEnum
 * @description:
 * @author: lukewei
 * @date: 2020-12-19 10:36
 * @remark: 修改内容
 */


public enum CodeEnum {

    /**
     *
     * @version V1.0.0
     * @title: ErrorCodeEnum
     * @description:
     * @author: wangyafei
     * @date: 2020/12/9 16:26
     * @remark:
     */
    /**
     * 命名约定：
     * 错误码 E[三位功能模块代码]_[4位该功能模块下各种错误码]
     * 正确码 S[三位功能模块代码]_[4位该功能模块下各种错误码]
     * 编码约定
     * 0、 正确码第一位固定为1，错误码第一位固定为5
     * 1、 第二至第四位：该功能模块下各种错误码
     * HTTP状态码请参考 HttpStatus 枚举类
     */
    S_COMMON_0001("COMMON", "通用", 10001, "注册成功"),
    S_COMMON_0002("COMMON", "通用", 10002, "新增成功"),
    S_COMMON_0003("COMMON", "通用", 10003, "更新成功"),
    S_COMMON_0004("COMMON", "通用", 10004, "新增或更新成功"),
    S_COMMON_0005("COMMON", "通用", 10005, "删除成功"),
    S_COMMON_0006("COMMON", "通用", 10006, "操作成功"),
    S_COMMON_0007("COMMON", "通用", 10007, "手机号可以正常注册"),
    S_COMMON_0008("COMMON", "通用", 10008, "密码重置成功"),
    S_COMMON_0009("COMMON", "通用", 10009, "取消绑定成功"),
    S_COMMON_0010("COMMON", "通用", 10010, "解除成功"),
    S_COMMON_0011("COMMON", "通用", 10011, "注销成功"),
    S_COMMON_0012("COMMON", "通用", 10012, "导入成功"),
    S_COMMON_0013("COMMON", "通用", 10013, "查询成功"),
    S_COMMON_0015("COMMON", "通用", 10015, "获取成功"),
    S_COMMON_0016("COMMON", "通用", 10016, "取消成功"),
    S_COMMON_0017("COMMON", "通用", 10017, "保存成功"),
    S_COMMON_0018("COMMON", "通用", 10018, "审核成功"),
    S_COMMON_0019("COMMON", "通用", 10019, "发送成功"),
    S_COMMON_0020("COMMON", "通用", 10020, "文件上传成功"),
    S_COMMON_0023("COMMON", "通用", 10023, "刷新成功"),

    E_COMMON_0001("COMMON", "通用", 50001, "注册失败"),
    E_COMMON_0002("COMMON", "通用", 50002, "新增失败"),
    E_COMMON_0003("COMMON", "通用", 50003, "更新失败"),
    E_COMMON_0004("COMMON", "通用", 50004, "新增或更新失败"),
    E_COMMON_0005("COMMON", "通用", 50005, "删除失败"),
    E_COMMON_0006("COMMON", "通用", 50006, "操作失败"),
    E_COMMON_0008("COMMON", "通用", 50008, "密码重置失败"),
    E_COMMON_0009("COMMON", "通用", 50009, "取消绑定失败"),
    E_COMMON_0010("COMMON", "通用", 50010, "解除失败"),
    E_COMMON_0011("COMMON", "通用", 50011, "注销失败"),
    E_COMMON_0012("COMMON", "通用", 50012, "导入失败"),
    E_COMMON_0013("COMMON", "通用", 50013, "查询失败"),
    E_COMMON_0014("COMMON", "通用", 50014, "没有查询到数据"),
    E_COMMON_0015("COMMON", "通用", 50015, "获取失败"),
    E_COMMON_0016("COMMON", "通用", 50016, "取消失败"),
    E_COMMON_0017("COMMON", "通用", 50017, "用户未登录"),
    E_COMMON_0018("COMMON", "通用", 50018, "id不能为null"),
    E_COMMON_0019("COMMON", "通用", 50019, "审核失败"),
    E_COMMON_0020("COMMON", "通用", 50020, "保存失败"),
    E_COMMON_0021("COMMON", "通用", 10021, "发送失败"),
    E_COMMON_0022("COMMON", "通用", 10022, "新增失败，已存在"),
    E_COMMON_0023("COMMON", "通用", 10023, "刷新失败"),


    E_COMMON_401("COMMON", "通用", 401, "您没有权限访问该接口"),
    E_COMMON_500("COMMON", "通用", 500, "未知异常"),
    E_COMMON_429("COMMON", "通用", 429, "您的操作过快, 请稍后再试!"),
    E_COMMON_PARAMETER_JSON("COMMON", "通用", 500, "参数校验失败:[请检查JSON是否正确]"),
    E_COMMON_PARAMETER("COMMON", "通用", 500, "参数校验失败"),
    E_COMMON_PARAMETER_TEMP("COMMON", "通用", 500, "参数校验失败"),


    /**
     * 命名约定：E[两位功能模块代码]_[4位该功能模块下各种错误码]
     * 编码约定
     * 0、 第一位标识单点登录系统
     * 1、 第二至第三位：功能模块代码
     * 2、 第四至第七位：该功能模块下各种错误码
     * HTTP状态码请参考 HttpStatus 枚举类
     */
    E_GATEWAY_CENTER_0001("GATEWAY_CENTER", "网关中心", 1000001, "数据库异常"),

    E_USER_CENTER_0001("USER_CENTER", "用户中心", 1010001, "身份证号已存在"),
    E_USER_CENTER_0002("USER_CENTER", "用户中心", 1010002, "手机号已存在"),
    E_USER_CENTER_0003("USER_CENTER", "用户中心", 1010003, "注册失败"),
    E_USER_CENTER_0004("USER_CENTER", "用户中心", 1010004, "图形验证码错误"),
    E_USER_CENTER_0005("USER_CENTER", "用户中心", 1010005, "短信验证码验证失败"),
    E_USER_CENTER_0006("USER_CENTER", "用户中心", 1010006, "手机号码已使用"),
    E_USER_CENTER_0007("USER_CENTER", "用户中心", 1010007, "获取登录用户失败，请检查token是否正确"),
    E_USER_CENTER_0008("USER_CENTER", "用户中心", 1010008, "短信验证码不正确"),
    E_USER_CENTER_0009("USER_CENTER", "用户中心", 1010009, "密码修改失败，原有密码不正确"),
    E_USER_CENTER_0010("USER_CENTER", "用户中心", 1010010, "手机号对应的用户不存在"),
    E_USER_CENTER_0011("USER_CENTER", "用户中心", 1010011, "自动创建用户失败，绑定失败"),
    E_USER_CENTER_0012("USER_CENTER", "用户中心", 1010012, "用户不存在"),
    E_USER_CENTER_0013("USER_CENTER", "用户中心", 1010013, "证件号已存在"),
    E_USER_CENTER_0014("USER_CENTER", "用户中心", 1010014, "取消绑定失败，没有获取到用户"),
    E_USER_CENTER_0015("USER_CENTER", "用户中心", 1010015, "该手机号对应的用户不存在"),


    E_UAA_CENTER_0001("UAA_CENTER", "认证中心", 1100001, "验证码未失效，请失效后再次申请"),
    E_UAA_CENTER_0002("UAA_CENTER", "认证中心", 1100002, "手机号不存在"),
    E_UAA_CENTER_0003("UAA_CENTER", "认证中心", 1100003, "文件类别仅支持：证明类、证据类、其他类"),
    E_UAA_CENTER_0004("UAA_CENTER", "认证中心", 1100004, "文件类别仅支持：证明类、证据类、其他类"),
    E_UAA_CENTER_0005("UAA_CENTER", "认证中心", 1100005, "文件类别仅支持：证明类、证据类、其他类"),
    E_UAA_CENTER_0006("UAA_CENTER", "认证中心", 1100006, "文件类别仅支持：证明类、证据类、其他类"),


    /**
     * uaa-bg
     *
     */
    E_UAA_BG_0001("UAA_BG", "后台用户中心", 1410001, "用户名已存在"),
    E_UAA_BG_0002("UAA_BG", "后台用户中心", 1410002, "用户不存在"),
    E_UAA_BG_0003("UAA_BG", "后台用户中心", 1410003, "旧密码不能为null"),
    E_UAA_BG_0004("UAA_BG", "后台用户中心", 1410004, "旧密码错误"),

    /**
     * 订单中心
     */
    S_ORDER_CENTER_0001("ORDER_CENTER", "订单中心", 1200001, "预约处理中，请稍后..."),
    S_ORDER_CENTER_0002("ORDER_CENTER", "订单中心", 1200002, "预约成功"),
    S_ORDER_CENTER_0003("ORDER_CENTER", "订单中心", 1200003, "核验成功"),
    S_ORDER_CENTER_0004("ORDER_CENTER", "订单中心", 1200004, "团队核验成功"),

    E_ORDER_CENTER_0001("ORDER_CENTER", "订单中心", 1210001, "请填写预约信息"),
    E_ORDER_CENTER_0002("ORDER_CENTER", "订单中心", 1210002, "请选择预约日期"),
    E_ORDER_CENTER_0003("ORDER_CENTER", "订单中心", 1210003, "请选择预约时段"),
    E_ORDER_CENTER_0004("ORDER_CENTER", "订单中心", 1210004, "请填写电子行程单单号"),
    E_ORDER_CENTER_0005("ORDER_CENTER", "订单中心", 1210005, "请填写导游证号码"),
    E_ORDER_CENTER_0006("ORDER_CENTER", "订单中心", 1210006, "请填写旅行社名称"),
    E_ORDER_CENTER_0007("ORDER_CENTER", "订单中心", 1210007, "请填写预约总人数"),
    E_ORDER_CENTER_0008("ORDER_CENTER", "订单中心", 1210008, "二维码已过期或者不正确，核验失败"),
    E_ORDER_CENTER_0009("ORDER_CENTER", "订单中心", 1210009, "没有查到此刻的预约，核验失败"),
    E_ORDER_CENTER_0010("ORDER_CENTER", "订单中心", 1210010, "健康宝审核失败"),
    E_ORDER_CENTER_0011("ORDER_CENTER", "订单中心", 1210011, "包含健康宝审核失败的身份证号码"),
    E_ORDER_CENTER_0012("ORDER_CENTER", "订单中心", 1210012, "没有找到该证件号所对应的预约信息"),
    E_ORDER_CENTER_0013("ORDER_CENTER", "订单中心", 1210013, "核验失败"),
    E_ORDER_CENTER_0014("ORDER_CENTER", "订单中心", 1210014, "获取大门信息失败"),


    /**
     * 系统中心
     */

    E_SYSTEM_CENTER_0001("SYSTEM_CENTER", "系统中心", 1310001, "获取大门信息失败"),
    E_SYSTEM_CENTER_0002("SYSTEM_CENTER", "系统中心", 1310002, "没有查到模板"),
    E_SYSTEM_CENTER_0003("SYSTEM_CENTER", "系统中心", 1310003, "消息发送失败"),
    E_SYSTEM_CENTER_0004("SYSTEM_CENTER", "系统中心", 1310004, "发送失败，超过最大发送次数,请在{param1}后重试"),
    E_SYSTEM_CENTER_0005("SYSTEM_CENTER", "系统中心", 1310005, "发送失败，请{param1}秒后重试"),

    /**
     * 产品中心
     */

    E_PRODUCT_CENTER_0001("PRODUCT_CENTER", "产品中心", 1710001, "该游览地下的游览时间段名称已经存在"),
    E_PRODUCT_CENTER_0002("PRODUCT_CENTER", "产品中心", 1710002, "该游览地下的游览时间段名称已经存在,请更换其他名称"),
    E_PRODUCT_CENTER_0003("PRODUCT_CENTER", "产品中心", 1710003, "核验口名称已经存在"),
    E_PRODUCT_CENTER_0004("PRODUCT_CENTER", "产品中心", 1710004, "核验口对应数字已经存在"),
    E_PRODUCT_CENTER_0005("PRODUCT_CENTER", "产品中心", 1710005, "该模板名称属性已经存在"),
    E_PRODUCT_CENTER_0006("PRODUCT_CENTER", "产品中心", 1710006, "提示信息类型已经存在"),


    /**
     * ID生成中心
     */
    E_ID_CENTER_0001("ID_CENTER", "ID生成中心", 1110001, "请将上传文件大小控制为10M以内"),


    S_COMMON_1001("COMMON", "通用", 1001, "新增成功"),
    S_COMMON_1002("COMMON", "通用", 1002, "新增失败"),
    S_COMMON_1003("COMMON", "通用", 1003, "修改成功"),
    S_COMMON_1004("COMMON", "通用", 1004, "修改失败"),
    S_COMMON_1005("COMMON", "通用", 1005, "查询成功"),
    S_COMMON_1006("COMMON", "通用", 1006, "查询失败"),
    S_COMMON_1007("COMMON", "通用", 1007, "删除成功"),
    S_COMMON_1008("COMMON", "通用", 1008, "删除失败"),
    S_COMMON_1009("COMMON", "通用", 1009, "操作成功"),
    S_COMMON_1010("COMMON", "通用", 1010, "操作失败"),


    // user
    S_COMMON_1101("COMMON", "通用", 1101, "注册成功"),
    S_COMMON_1102("COMMON", "通用", 1102, "注册失败"),
    S_COMMON_1103("COMMON", "通用", 1103, "用户名已存在"),
    S_COMMON_1104("COMMON", "通用", 1104, "旧密码不能为null"),
    S_COMMON_1105("COMMON", "通用", 1105, "旧密码错误"),
    S_COMMON_1106("COMMON", "通用", 1106, "未查询到数据"),
    S_COMMON_1107("COMMON", "通用", 1107, "请检查name,url,type,sort,path,parentId是否为null"),
    S_COMMON_1108("COMMON", "通用", 1108, "管理员不可以删除"),
    S_COMMON_1109("COMMON", "通用", 1109, "用户名或密码错误"),
    S_COMMON_1110("COMMON", "通用", 1110, "手机号或密码错误"),
    S_COMMON_1111("COMMON", "通用", 1111, "openId错误"),
    S_COMMON_1112("COMMON", "通用", 1112, "请检查角色ID，和菜单ID参数"),

    // 订单
    S_COMMON_1201("COMMON", "通用", 1201, "成功获取购物车信息"),
    S_COMMON_1202("COMMON", "通用", 1202, "当前购物车为空"),
    S_COMMON_1203("COMMON", "通用", 1203, "购物车添加成功"),
    S_COMMON_1204("COMMON", "通用", 1204, "游览时间不能为空"),
    S_COMMON_1205("COMMON", "通用", 1205, "订单项不存在"),
    S_COMMON_1206("COMMON", "通用", 1206, "验票时间更新成功"),
    S_COMMON_1207("COMMON", "通用", 1207, "用户未登录"),
    S_COMMON_1208("COMMON", "通用", 1208, "下单处理中，请等待"),
    S_COMMON_1209("COMMON", "通用", 1209, "购物车不存在"),
    S_COMMON_1210("COMMON", "通用", 1210, "订单待支付"),
    S_COMMON_1211("COMMON", "通用", 1211, "订单保存失败,请重试"),
    S_COMMON_1212("COMMON", "通用", 1212, "订单处理中"),
    S_COMMON_1213("COMMON", "通用", 1213, "支付成功"),
    S_COMMON_1214("COMMON", "通用", 1214, "订单支付失败，系统异常"),
    S_COMMON_1215("COMMON", "通用", 1215, "已预约、请勿重复预约"),
    S_COMMON_1216("COMMON", "通用", 1216, "预约额已满"),
    S_COMMON_1217("COMMON", "通用", 1217, "预约失败,发送预约申请失败"),
    S_COMMON_1218("COMMON", "通用", 1218, "预约成功"),
    S_COMMON_1219("COMMON", "通用", 1219, "[orderId]不能为空"),
    S_COMMON_1220("COMMON", "通用", 1220, "已超时,不允许取消"),
    S_COMMON_1221("COMMON", "通用", 1221, "预约失败，发送撤销申请失败"),
    S_COMMON_1222("COMMON", "通用", 1222, "撤销成功"),
    S_COMMON_1223("COMMON", "通用", 1223, "撤销失败"),
    S_COMMON_1224("COMMON", "通用", 1224, "该预约已入园使用，不可取消预约"),
    S_COMMON_1225("COMMON", "通用", 1225, "未找到用户信息"),
    S_COMMON_1226("COMMON", "通用", 1226, "[customerId]不能为空"),
    S_COMMON_1227("COMMON", "通用", 1227, "未查询到对应预约信息"),
    S_COMMON_1228("COMMON", "通用", 1228, "不能为空"),


    S_COMMON_9101("COMMON", "通用", 1101, "注册成功");


    private String functionCode;
    private String functionDesc;
    private Integer code;
    private String message;

    /**
     * @param functionCode 功能模块代码
     * @param functionDesc 功能模块描述
     * @param code         编码
     * @param message      错误码的含义, 也可以前端自行定义
     */
    CodeEnum(String functionCode, String functionDesc, Integer code, String message) {
        this.functionCode = functionCode;
        this.functionDesc = functionDesc;
        this.code = code;
        this.message = message;
    }


    public String getFunctionCode() {
        return functionCode;
    }

    public String getFunctionDesc() {
        return functionDesc;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
