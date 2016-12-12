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

import java.util.ArrayList;

/**
 * Created by uas.sorokin@gmail.com
 */
public class SimplePoolBase<T> implements SimplePool<T> {

    private final ArrayList<T> mPool;
    private final ObjectFactory<T> mFactory;

    public SimplePoolBase(ObjectFactory<T> objectFactory) {
        if (objectFactory == null) {
            throw new IllegalArgumentException("objectFactory is null");
        }
        mPool = new ArrayList<>();
        mFactory = objectFactory;
    }

    public T acquire() {
        if (mPool.isEmpty()) {
            return mFactory.newObject();
        } else {
            return mPool.remove(mPool.size() - 1);
        }
    }

    public void release(T object) {
        if (object == null) {
            throw new IllegalArgumentException("object is null");
        }
        mFactory.reset(object);
        mPool.add(object);
    }

}