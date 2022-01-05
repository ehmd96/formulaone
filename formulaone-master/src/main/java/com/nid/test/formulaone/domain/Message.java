package com.nid.test.formulaone.domain;

public class Message {

    private Integer code;
    private String content;

    public Message() {}

    public Message(Integer code, String content) {
        this.code = code;
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", content='" + content + '\'' +
                '}';
    }
}
