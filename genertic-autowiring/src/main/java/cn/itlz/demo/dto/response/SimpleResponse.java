package cn.itlz.demo.dto.response;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/2 0002
 */
public class SimpleResponse {
    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
