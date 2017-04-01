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

/**
 * Handler that replaces the value of a given HTTP header.
 */
public class HttpHeaderRewriter extends AbstractHttpRequestHandler {
    private final String headerName;
    private final String newValue;
    
    public HttpHeaderRewriter(String headerName, String newValue) {
        this.headerName = headerName;
        this.newValue = newValue;
    }

    public void handleHeaders(Headers headers) {
        headers.set(headerName, newValue);
    }
}
