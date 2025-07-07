abstract class User{
    constructor(
        private firstName:string,
        private lastName:string,
        public nickname:string
    ){}
    getFullName(){
        return `${this.firstName} ${this.lastName}`
    }
}

class Player extends User{

}

const nico = new Player("nico","las", "니꼬")

// nico.firstName = private이라 인식 안됨
nico.nickname
nico.getFullName()

//
type Words = {
    [key:string] :string
}

class Dict {
    private words: Words
    constructor() {
        this.words = {}
    }
    add(word:Word){
        if (this.words[word.term] === undefined) {
            this.words[word.term] = word.def;
        }
    }

    def(term: string) {
        return this.words[term]
    }
}

class Word {
    constructor(
        public term:string,
        public def :string
    ) {}
}

const kimchi = new Word("kimchi", "한국의 음식");
const dict = new Dict();
dict.add(kimchi);
dict.def("kimchi");