package com.parrot.automation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses({
	TestUnit.class,
	TestLogin.class,
	TestPedidos.class
})

public class ExecuteSuite {}
