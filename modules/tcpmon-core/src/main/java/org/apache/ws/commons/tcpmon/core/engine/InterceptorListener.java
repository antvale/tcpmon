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

package org.apache.ws.commons.tcpmon.core.engine;

public interface InterceptorListener {
    void onServerSocketStart();
    void onServerSocketError(Throwable ex);
    
    /**
     * Create a listener for a new request-response exchange.
     * 
     * @param fromHost
     * @return the listener or <code>null</code> if the implementation is not interested
     *         in receiving events for a request-response exchange
     */
    RequestResponseListener createRequestResponseListener(String fromHost);
}
