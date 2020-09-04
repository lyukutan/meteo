function getIndex(list, id) {
    for (var i = 0; i < list.length; i++) {
        if (list[i].id === id) {
            return i;
        }
    }

    return -1;
}


var personApi = Vue.resource('/person{/id}');

Vue.component('person-form', {
    props: ['persons', 'personAttr'],
    data: function () {
        return {
            ident: '',
            fio: '',
            id: ''
        }
    },
    watch: {
        personAttr: function (newVal, oldVal) {
            this.country = newVal.country;
            this.ident = newVal.ident;
            this.fio = newVal.fio;
            this.id = newVal.id;
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="FIO" v-model="fio" />' +
        '<input type="text" placeholder="ident" v-model="ident" />' +
        '<input type="text" placeholder="country" v-model="country" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>' + '</br>' + '</br>',
    methods: {
        save: function () {
            var person = {fio: this.fio, ident: this.ident, country: this.country};

            if (this.id) {
                personApi.update({id: this.id}, person).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.persons, data.id);
                        this.persons.splice(index, 1, data);
                        this.country = '';
                        this.ident = '';
                        this.fio = '';
                        this.id = ''
                    })
                )
            } else {
                personApi.save({}, person).then(result =>
                    result.json().then(data => {
                        this.persons.push(data);
                        this.fio = '';
                        this.ident = '';
                        this.country = ''
                    })
                )
            }
        }
    }
});

Vue.component('person-row', {
    props: ['person', 'editMethod', 'persons'],
    template: '<div>' + '</br>' +
        '<i>({{ person.id }})</i> {{ person.fio }}  {{ person.ident }}' +
        '<span style="position: fixed">' +
        '  ' + '<input type="button" value="Edit" @click="edit" />' +
        '<input type="button" value="X" @click="del" />' +
        '</span>' +
        '</div>',
    methods: {
        edit: function () {
            this.editMethod(this.person);
        },
        del: function () {
            personApi.remove({id: this.person.id}).then(result => {
                if (result.ok) {
                    this.persons.splice(this.persons.indexOf(this.person), 1)
                }
            })
        }
    }
});

Vue.component('persons-list', {
    props: ['persons'],
    data: function () {
        return {
            person: null
        }
    },
    template:
        '<div style="position: relative; width: 300px;">' +
        '<person-form :persons="persons" :personAttr="person" />' +
        '<person-row v-for="person in persons" :key="person.id" :person="person" ' +
        ':editMethod="editMethod" :persons="persons" />' +
        '</div>',
    created: function () {
        personApi.get().then(result =>
            result.json().then(data =>
                data.forEach(person => this.persons.push(person))
            )
        )
    },
    methods: {
        editMethod: function (person) {
            this.person = person;
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<persons-list :persons="persons" />',
    data: {
        persons: []
    }
});
