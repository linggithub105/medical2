package cn.ling.medicalview.pojo.enmu;

/**
 * @program: medical2
 * @author: zhanling.li
 * @create: 2021-06-02 22:14
 */
public enum  TestEnmu {
    UNKNOW_EXCEPTION(10,"我是参数验证不通过"),
    VAILD_EXCEPTION(100,"你想怎么样啊！");

    private int code;
    private String mes;

    TestEnmu(int code, String mes) {
        this.code = code;
        this.mes = mes;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
