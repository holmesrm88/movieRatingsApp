package com.holmes.movieApplication.util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Clob;
import java.sql.SQLException;

public class MovieApplicationUtil {

    public static String clobToString(Clob clob) throws SQLException, IOException {
        InputStream in = clob.getAsciiStream();
        StringWriter w = new StringWriter();
        IOUtils.copy(in, w);
        String s = w.toString();
        return s;
    }
}
