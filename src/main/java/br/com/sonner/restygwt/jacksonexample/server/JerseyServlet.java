/**
 * Copyright (C) 2009-2012 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.sonner.restygwt.jacksonexample.server;

import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * This servlet is a horible hack to integrate jersey /w gwt hosted mode junit
 * tests.
 * 
 * @author <a href="http://hiramchirino.com">Hiram Chirino</a>
 */
public class JerseyServlet extends com.sun.jersey.spi.container.servlet.ServletContainer {

    private static final long serialVersionUID = -273961734543645503L;

    private static Properties initParams = new Properties();
    static {
//    org.codehaus.jackson.jaxrs
    	try {
			Class.forName("com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        initParams.put("com.sun.jersey.config.property.packages", "br.com.sonner.restygwt.jacksonexample.server;com.fasterxml.jackson.jaxrs");
//        initParams.put("com.sun.jersey.config.property.packages", "br.com.sonner.restygwt.jacksonexample.server;org.codehaus.jackson.jaxrs");
    }

    public void init(final ServletConfig servletConfig) throws ServletException {
    	System.out.println("Initing#################");
        super.init(new ServletConfig() {
            public String getServletName() {
                return servletConfig.getServletName();
            }

            public ServletContext getServletContext() {
                return servletConfig.getServletContext();
            }

            @SuppressWarnings("unchecked")
            public Enumeration getInitParameterNames() {
                return initParams.keys();
            }

            public String getInitParameter(String name) {
                return initParams.getProperty(name);
            }
        });
    }

   
}
