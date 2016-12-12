/*
 * Copyright (C) 2016 Alexander Sorokin (alexoro)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.alexoro.simplepool;

/**
 * Created by uas.sorokin@gmail.com
 */
public class SimplePoolThreadSafe<T> implements SimplePool<T> {

    private final SimplePoolBase<T> mDelegate;

    public SimplePoolThreadSafe(ObjectFactory<T> objectFactory) {
        mDelegate = new SimplePoolBase<>(objectFactory);
    }

    @Override
    public synchronized T acquire() {
        return mDelegate.acquire();
    }

    @Override
    public synchronized void release(T object) {
        mDelegate.release(object);
    }

}