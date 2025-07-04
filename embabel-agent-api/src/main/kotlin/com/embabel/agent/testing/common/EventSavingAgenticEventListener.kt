/*
 * Copyright 2024-2025 Embabel Software, Inc.
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
package com.embabel.agent.testing.common

import com.embabel.agent.event.AgentPlatformEvent
import com.embabel.agent.event.AgentProcessEvent
import com.embabel.agent.event.AgenticEventListener

/**
 * Simple implementation of [com.embabel.agent.event.AgenticEventListener] that saves each kind of event to a list.
 */
class EventSavingAgenticEventListener : AgenticEventListener {

    private val _platformEvents = mutableListOf<AgentPlatformEvent>()

    private val _processEvents = mutableListOf<AgentProcessEvent>()

    override fun onPlatformEvent(event: AgentPlatformEvent) {
        _platformEvents += event
    }

    override fun onProcessEvent(event: AgentProcessEvent) {
        _processEvents += event
    }

    val platformEvents get() = _platformEvents.toList()

    val processEvents get() = _processEvents.toList()
}
