package org.example;

/**
 * @author yufangwu
 */
public enum RuleEnum {
   CHE("1","车走直线随便走几步"),
   MA("2","马走日字会被蹩马脚"),
   PAO("3","炮走直线随便走几步，然后吃子要架炮"),
   XIANG("4","象走田字形会被塞相眼"),
   SHI("5","士走斜线不能出九宫格"),
   JIANG("6","将走直线只能一步一步走不能出九宫格"),
   PING("7","兵走直线只能一步一步走没过河之前只能竖着走"),
  ;

  private String code;

  private String name;


  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static RuleEnum getRuleEnum(String code) {
    for (RuleEnum ruleEnum : RuleEnum.values()) {
      if (ruleEnum.getCode().equals(code)) {
        return ruleEnum;
      }
    }
    return null;
  }

   RuleEnum(String code, String name) {
    this.code = code;
    this.name = name;
  }

}
