/*
 * Copyright 2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ws.commons.tcpmon.core.filter.http;

import java.util.LinkedList;
import java.util.List;

/**
 * Filter that parses HTTP requests and invokes a set of {@link HTTPRequestHandler}
 * implementations.
 */
public class HttpRequestFilter extends HttpFilter {
    private final List<HttpRequestHandler> handlers = new LinkedList<HttpRequestHandler>();
    
    public HttpRequestFilter(boolean decodeTransferEncoding) {
        super(decodeTransferEncoding);
    }

    public void addHandler(HttpRequestHandler handler) {
        handlers.add(handler);
    }

    @Override
    protected String processFirstLine(String firstLine) {
        for (HttpRequestHandler handler : handlers) {
            firstLine = handler.processRequestLine(firstLine);
        }
        return firstLine;
    }

    @Override
    protected void processHeaders(Headers headers) {
        for (HttpRequestHandler handler : handlers) {
            handler.processRequestHeaders(headers);
        }
    }

    @Override
    protected void completed() {
        for (HttpRequestHandler handler : handlers) {
            handler.requestCompleted();
        }
    }
}
