/*
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
;
(function($, window, document, undefined) {
  'use strict';

  var output = function(msg) {
    window.console && console.log(msg);
  };

  var WanSpinner = function(element, options) {
    this.defaults = {
      maxValue: 999,
      minValue: -999,
      step: 1,
      start: 1,
      inputWidth: 40,
      plusClick: function(element, val) {
        return true;
      },
      minusClick: function(element, val) {
        return true;
      },
      exceptionFun: function(element, exp) {
        return true;
      },
      valueChanged: function(element, val) {
        return true;
      }
    };
    this.options = $.extend({}, this.defaults, options);
    this.options.stepLength = ((+this.options.step).toString().split('.')[1] || '').length;
    this.options.stepFloat = parseInt(1 * Math.pow(10, this.options.stepLength) / this.options.step) || 1;
    this.element = $(element);

    this.options.exceptionFunEnable = (typeof(this.options.exceptionFun) === 'function');
    this.options.plusClickEnable = (typeof(this.options.plusClick) === 'function');
    this.options.minusClickEnable = (typeof(this.options.minusClick) === 'function');
    this.options.valueChangedEnable = (typeof(this.options.valueChanged) === 'function');

    this.element.each(function(index, dt) {
      var input = $(dt).children('input');
      var initValue = input.val() || this.options.start;
      input.val(initValue);
    });

    this.element.children('input');

    this.EXCEPTION = {
      TOO_LARGE: 1,
      NORMAL: 0,
      TOO_SMALL: -1
    };
  };

  WanSpinner.prototype.bind = function() {
    var self = this;
    $(self.element).delegate('.minus', 'click', function() {
      var val;
      var input = $(this).siblings('input');
      if (self.options.stepFloat > 1) {
        val = (+input.val() || 0) * self.options.stepFloat - self.options.step  * self.options.stepFloat;
        val = Math.round(val) / self.options.stepFloat;
      } else {
        val = (+input.val() || 0) - self.options.step;
      }
      val = val.toFixed(self.options.stepLength);
      if (val < self.options.minValue) {
        self.options.exceptionFunEnable && self.options.exceptionFun($(this).parent(), self.EXCEPTION.TOO_SMALL);
      } else {
        input.val(val);
        self.options.minusClickEnable && self.options.minusClick($(this).parent(), val);
        self.options.valueChangedEnable && self.options.valueChanged($(this).parent(), val);
      }
      return false;
    }).delegate('.plus', 'click', function() {
      var val;
      var input = $(this).siblings('input');
      if (self.options.stepFloat > 1) {
        val = (+input.val() || 0) * self.options.stepFloat + self.options.step * self.options.stepFloat;
        val = Math.round(val) / self.options.stepFloat;
      } else {
        val = (+input.val() || 0) + self.options.step;
      }
      val = val.toFixed(self.options.stepLength);
      if (val > self.options.maxValue) {
        self.options.exceptionFunEnable && self.options.exceptionFun($(this).parent(), self.EXCEPTION.TOO_LARGE);
      } else {
        input.val(val);
        self.options.plusClickEnable && self.options.plusClick($(this).parent(), val);
        self.options.valueChangedEnable && self.options.valueChanged($(this).parent(), val);
      }
      return false;
    }).delegate('input', 'change', function() {
      var val = +$(this).val() || 0;
      if (val > self.options.maxValue) {
        val = self.options.maxValue;
        self.options.exceptionFunEnable && self.options.exceptionFun($(this).parent(), self.EXCEPTION.TOO_LARGE);
      } else if (val < self.options.minValue) {
        val = self.options.minValue;
        self.options.exceptionFunEnable && self.options.exceptionFun($(this).parent(), self.EXCEPTION.TOO_SMALL);
      }
      $(this).val(val);
      self.options.valueChangedEnable && self.options.valueChanged($(this).parent(), val);
    });
  }


  $.fn.WanSpinner = function(options) {
    var wanSpinner = new WanSpinner(this, options);
    wanSpinner.bind();
    return this;
  };

})(jQuery, window, document);
