/*
 * Copyright (c) 2008-2016, Hazelcast, Inc. All Rights Reserved.
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
 */

package com.hazelcast.monitor;

public interface NearCacheStats extends LocalInstanceStats {

    /**
     * Returns the creation time of this Near Cache on this member.
     *
     * @return creation time of this Near Cache on this member.
     */
    long getCreationTime();

    /**
     * Returns the number of Near Cache entries owned by this member.
     *
     * @return number of Near Cache entries owned by this member.
     */
    long getOwnedEntryCount();

    /**
     * Returns memory cost (number of bytes) of Near Cache entries owned by this member.
     *
     * @return memory cost (number of bytes) of Near Cache entries owned by this member.
     */
    long getOwnedEntryMemoryCost();

    /**
     * Returns the number of hits (reads) of Near Cache entries owned by this member.
     *
     * @return number of hits (reads) of Near Cache entries owned by this member.
     */
    long getHits();

    /**
     * Returns the number of misses of Near Cache entries owned by this member.
     *
     * @return number of misses of Near Cache entries owned by this member.
     */
    long getMisses();

    /**
     * Returns the hit/miss ratio of Near Cache entries owned by this member.
     *
     * @return hit/miss ratio of Near Cache entries owned by this member.
     */
    double getRatio();

    /**
     * Returns the number of evictions of Near Cache entries owned by this member.
     *
     * @return number of evictions of Near Cache entries owned by this member.
     */
    long getEvictions();

    /**
     * Returns the number of TTL and max-idle expirations of Near Cache entries owned by this member.
     *
     * @return number of TTL and max-idle expirations of Near Cache entries owned by this member.
     */
    long getExpirations();
}
