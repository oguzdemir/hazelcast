/*
 * Copyright (c) 2008-2010, Hazel Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.hazelcast.concurrent.semaphore.client;

import com.hazelcast.concurrent.semaphore.SemaphoreProxy;
import com.hazelcast.concurrent.semaphore.SemaphoreService;
import com.hazelcast.instance.Node;
import com.hazelcast.nio.Protocol;
import com.hazelcast.nio.serialization.Data;

public class AcquireHandler extends SemaphoreCommandHandler {
    public AcquireHandler(SemaphoreService semaphoreService) {
        super(semaphoreService);
    }

    @Override
    public Protocol processCall(Node node, Protocol protocol) {
        SemaphoreProxy sp = getSemaphoreProxy(protocol.args[0]);
        int permits = Integer.valueOf(protocol.args[1]);
        try {
            sp.acquire(permits);
            return protocol.success();
        } catch (InterruptedException e) {
            return protocol.error(new Data[]{node.serializationService.toData(e)}, e.getClass().getName());
        }
    }
}
