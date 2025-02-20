/*
 * Copyright 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.shell.samples.e2e;

import org.springframework.context.annotation.Bean;
import org.springframework.shell.command.CommandRegistration;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * Commands used for e2e test.
 *
 * @author Janne Valkealahti
 */
@ShellComponent
public class DefaultValueCommands extends BaseE2ECommands {

	@ShellMethod(key = LEGACY_ANNO + "default-value", group = GROUP)
	public String testDefaultValue(
		@ShellOption(defaultValue = "hi") String arg1
	) {
		return "Hello " + arg1;
	}

	@Bean
	public CommandRegistration testDefaultValueRegistration(CommandRegistration.BuilderSupplier builder) {
		return builder.get()
			.command(REG, "default-value")
			.group(GROUP)
			.withOption()
				.longNames("arg1")
				.defaultValue("hi")
				.and()
			.withTarget()
				.function(ctx -> {
					String arg1 = ctx.getOptionValue("arg1");
					return "Hello " + arg1;
				})
				.and()
			.build();
	}

	@ShellMethod(key = LEGACY_ANNO + "default-value-boolean1", group = GROUP)
	public String testDefaultValueBoolean1(
		@ShellOption(defaultValue = "false") boolean arg1
	) {
		return "Hello " + arg1;
	}

	@Bean
	public CommandRegistration testDefaultValueBoolean1Registration(CommandRegistration.BuilderSupplier builder) {
		return builder.get()
			.command(REG, "default-value-boolean1")
			.group(GROUP)
			.withOption()
				.longNames("arg1")
				.defaultValue("false")
				.type(boolean.class)
				.and()
			.withTarget()
				.function(ctx -> {
					boolean arg1 = ctx.getOptionValue("arg1");
					return "Hello " + arg1;
				})
				.and()
			.build();
	}

	@ShellMethod(key = LEGACY_ANNO + "default-value-boolean2", group = GROUP)
	public String testDefaultValueBoolean2(
		@ShellOption(defaultValue = "true") boolean arg1
	) {
		return "Hello " + arg1;
	}

	@Bean
	public CommandRegistration testDefaultValueBoolean2Registration(CommandRegistration.BuilderSupplier builder) {
		return builder.get()
			.command(REG, "default-value-boolean2")
			.group(GROUP)
			.withOption()
				.longNames("arg1")
				.defaultValue("true")
				.type(boolean.class)
				.and()
			.withTarget()
				.function(ctx -> {
					boolean arg1 = ctx.getOptionValue("arg1");
					return "Hello " + arg1;
				})
				.and()
			.build();
	}

	@ShellMethod(key = LEGACY_ANNO + "default-value-boolean3", group = GROUP)
	public String testDefaultValueBoolean3(
		@ShellOption boolean arg1
	) {
		return "Hello " + arg1;
	}

	@Bean
	public CommandRegistration testDefaultValueBoolean3Registration(CommandRegistration.BuilderSupplier builder) {
		return builder.get()
			.command(REG, "default-value-boolean3")
			.group(GROUP)
			.withOption()
				.longNames("arg1")
				.required(false)
				.type(boolean.class)
				.defaultValue("false")
				.and()
			.withTarget()
				.function(ctx -> {
					boolean arg1 = ctx.getOptionValue("arg1");
					return "Hello " + arg1;
				})
				.and()
			.build();
	}
}
