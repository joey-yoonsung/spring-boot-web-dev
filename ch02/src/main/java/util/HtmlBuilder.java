package util;

import java.io.IOException;
import java.io.Writer;

public class HtmlBuilder {

    Writer writer;
    
    public HtmlBuilder(Writer writer) {
        this.writer=writer;
    }

    public util.HtmlBuilder writeBasicHtml(String content) throws IOException {
        writer.append("<html>");
        writer.append("<head>Yoonsung</head>");
        writer.append("<body><p>" + content + "</p></body>");
        writer.append("</html>");
        return this;
    }

    public util.HtmlBuilder startHtml() throws IOException {
        writer.append("<html>");
        return this;
    }

    public util.HtmlBuilder endHtml() throws IOException {
        writer.append("</html>");
        return this;
    }

    public util.HtmlBuilder startBody() throws IOException {
        writer.append("<body>");
        return this;
    }

    public util.HtmlBuilder endBody() throws IOException {
        writer.append("</body>");
        return this;
    }

    public util.HtmlBuilder writeLine(String content) throws IOException {
        writer.append("<div>"+ content + "</div>");
        return this;
    }


    public util.HtmlBuilder writeHead(String content) throws IOException {
        writer.append("<head>" + content + "\n</head>");
        return this;
    }

    public util.HtmlBuilder writeBody(String content) throws IOException {
        writer.append("<body><div>" + content + "</div></body>");
        return this;
    }
}
