package cn.itlz.demo.zuul.dto.response;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/10 0010
 */
public class SimpleResponse {
    private String content;

    public SimpleResponse() {
    }

    public SimpleResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
