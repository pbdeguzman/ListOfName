package com.example.listofname.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listofname.model.Person

class MainViewModel: ViewModel() {
        var list = MutableLiveData<ArrayList<Person>>()
        private var newList = arrayListOf<Person>()

        fun addPerson(person: Person) {
            newList.add(person)
            list.value = newList
        }

        fun initMockData() {
            addPerson(Person("Asuza"))
            addPerson(Person("Elaina"))
            addPerson(Person("Hinata"))
            addPerson(Person("Kira"))
            addPerson(Person("Lacus"))
            addPerson(Person("Naruto"))
            addPerson(Person("Patrick"))
            addPerson(Person("Shinji"))
            addPerson(Person("Sinon"))
        }
}