/*
 * Copyright 2014 John Ahlroos
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
package fi.jasoft.dragdroplayouts.ui.tests;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

public class TestProvider extends UIProvider {

  @Override
  public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {

    String testClass = event.getRequest().getParameter("test");
    if (testClass != null) {
      try {
        return (Class<? extends UI>) Class.forName(testClass);
      } catch (ClassNotFoundException e) {
        // Ignore
      }
    }

    return NoTestFoundUI.class;
  }

  public static class NoTestFoundUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
      setContent(new Label("No test with that name could be found."));
    }

  }

}
