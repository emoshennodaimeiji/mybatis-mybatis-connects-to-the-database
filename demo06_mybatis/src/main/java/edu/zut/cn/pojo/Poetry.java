package edu.zut.cn.pojo;

public class Poetry {
    private String name;
    private String author;
    private String dynasty;

    @Override
    public String toString() {
        return "Poetry{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Poetry() {
    }

    public Poetry(String name) {
        this.name = name;
    }


    public Poetry(String name, String author, String dynasty, String content) {
        this.name = name;
        this.author = author;
        this.dynasty = dynasty;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;
}
